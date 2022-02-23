import java.util.Arrays;

class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] resultArr = new String[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            String result = changeNumToSharp(Integer.toBinaryString(arr1[i] | arr2[i]));
            resultArr[i] = setSizeSync(result, n);
        }
        return resultArr;
    }

    private static String changeNumToSharp(String binaryNum) {
        return binaryNum.replace('1', '#').replace('0', ' ');
    }

    private static String setSizeSync(String str, int n) {
        StringBuilder sb = new StringBuilder();
        if (str.length() != n) {
            for (int i = 0; i < n - str.length(); i++) {
                sb.append(" ");
            }
        }
        return sb.append(str).toString();
    }
}