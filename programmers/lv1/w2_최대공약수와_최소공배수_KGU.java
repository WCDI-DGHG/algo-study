/* 
최대공약수와 최소공배수
https://programmers.co.kr/learn/courses/30/lessons/12940
Code_By_Goun
*/

class Solution {
    static void gcd(int a, int b, int[] answer) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        answer[0] = a;
    }
    
    static void lcm(int a, int b, int[] answer) {
        answer[1] = (a * b) / answer[0];
    }
    
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        gcd(n, m, answer);
        lcm(n, m, answer);
        
        return answer;
    }
}