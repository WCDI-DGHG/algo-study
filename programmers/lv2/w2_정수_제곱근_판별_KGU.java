/* 
정수 제곱근 판별
https://programmers.co.kr/learn/courses/30/lessons/12934
Code_By_Goun
*/

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        answer = (Math.sqrt(n) % 1 != 0) ? -1 : (long) Math.pow(Math.sqrt(n) + 1, 2);
        
        // double mid = Math.sqrt(n);
        // if (mid % 1 != 0) {
        //     answer = -1;
        // } else {
        //     answer = (long) Math.pow(mid + 1, 2);
        // }
        
        return answer;
    }
}