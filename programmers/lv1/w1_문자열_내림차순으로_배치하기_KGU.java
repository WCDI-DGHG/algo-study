/*
문자열 내림차순으로 배치하기
https://programmers.co.kr/learn/courses/30/lessons/12917#
Code_By_Goun
*/

// 시도1: 부분 성공 -> 실패원인: 동일한 문자가 있을 경우 해결방안을 찾지 못함.
class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        char max = s.charAt(0);
        char mMax = (char)('z' + 1);
        
        for (int i = 0; i < len; i++) {    
            for(int j = 0; j < len; j++) {
                char alpha = s.charAt(j);
                if (alpha < mMax && max < alpha) {
                    max = s.charAt(j);
                }
            } 
            answer += max;
            mMax = max;
            max = (char)('A');
        }
        
        return answer;
    }
}

// 시도2: 배열이용
