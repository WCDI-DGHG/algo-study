/*
문자열 다루기 기본
https://programmers.co.kr/learn/courses/30/lessons/12918
Code_By_Goun
*/

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
        if (len == 4 || len == 6) {
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (ch < '0' || ch > '9') {
                    answer = false;
                }
            }
        } else {
            answer = false;
        }
        
        return answer;
    }
}