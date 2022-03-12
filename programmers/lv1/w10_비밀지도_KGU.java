/* 
Programmers
2진법
비밀지도
Code_By_Goun
*/

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
        	answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        	int len = answer[i].length();
        	if (len < n) {
        		String temp = "";
        		for (int x = 0; x < n - len; x++) {
        			temp += "0";
        		}
        		answer[i] = temp + answer[i];
        	}
        	
        	answer[i] = answer[i].replace('1', '#');
        	answer[i] = answer[i].replace('0', ' ');
        }

        return answer;
    }
}
