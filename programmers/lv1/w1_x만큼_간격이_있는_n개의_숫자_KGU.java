// x만큼 간격이 있는 n개의 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12954#qna

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long sum = x;
        
        for (int i = 0; i < n; i++) {
            answer[i] = sum;
            sum += x;
        }
        
        return answer;
    }
}
