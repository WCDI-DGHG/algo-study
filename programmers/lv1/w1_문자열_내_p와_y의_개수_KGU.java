/*
문자열 내 p와 y의 개수
https://programmers.co.kr/learn/courses/30/lessons/12916?language=java
Code_By_Goun
*/

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int len = s.length();
        int countP = 0, countY = 0;
            
        for (int i = 0; i < len; i++) {
            int ch = s.charAt(i);
            if(ch == 'P' || ch == 'p') {
                countP++;   
            } else if (ch == 'Y' || ch == 'y') {
                countY++;
            }
        }
        
        if (countP == countY) {
            answer = true;
        } else {
            answer = false;
        }
    
        return answer;
    }
}