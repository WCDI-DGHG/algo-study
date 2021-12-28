// 가운데 글자 가져오기
// https://programmers.co.kr/learn/courses/30/lessons/12903

class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        int mid = len / 2;
        
        if(len % 2 == 1) {
            answer = String.valueOf(s.charAt(mid));
        } else {
            answer = s.substring(mid -1, mid + 1);
        }
        
        
        return answer;
    }
}
