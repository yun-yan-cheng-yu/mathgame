package main;

public class BirthdaySame {
    public static void main(String[] args) {
        String num1 = "2147483647";
        String num2 = "2147483647";
        int[] array1 = toIntArray(num1);
        int[] array2 = toIntArray(num2);
        assert array1 != null;
        assert array2 != null;
        int totalLength = array1.length + array2.length;
        int[][] arr = new int[array2.length][];//每个数组存一个长度为totalLength的数组
        for (int i = 0; i < array2.length; i++) {
            arr[i] = new int[totalLength];
            int num = array2[array2.length - 1 - i];//数字2的最右边第几个
            int jinwei = 0;
            for (int j = 0; j < array1.length; j++) {
                int num3 = array1[array1.length - 1 - j];
                int shuzi = (num3 * num + jinwei) % 10;
                jinwei = (num3 * num + jinwei) / 10;
                arr[i][totalLength - 1 - j - i] = shuzi;
            }
            if (jinwei != 0) {
                arr[i][totalLength - array1.length - 1] = jinwei;
            }
        }
        //System.out.println(Arrays.deepToString(arr));
        StringBuilder answer = new StringBuilder();
        int jinwei = 0;
        for (int i = 0; i < totalLength; i++) {
            int totalNum = jinwei;
            for (int[] ints : arr) {
                totalNum += ints[totalLength - i - 1];
            }
            jinwei = totalNum / 10;
            int shuzi =totalNum%10;
            answer.insert(0,shuzi);
        }
        System.out.println(answer);
    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private static int[] toIntArray(String num) {
        char[] numChar = num.toCharArray();
        int[] numInt = new int[num.length()];
        for (int i = 0; i < numChar.length; i++) {
            if (!isNum(numChar[i])) {
                logError("出现非法数字", num);
                return null;
            }
            numInt[i] = numChar[i] - '0';
        }
        return numInt;
    }

    private static void logError(Object... objects) {
        for (Object s : objects) {
            System.out.print(s + "\t");
        }
        System.out.println();
    }
}
