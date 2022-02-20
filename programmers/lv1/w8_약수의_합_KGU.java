/* 
Programmers
약수의 합
Code_By_Goun
*/

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
        	if(n % i == 0) {
        		answer += i;
        	}
        }
        return answer;
    }
}

public class Main{
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.solution(12));
		System.out.println(s.solution(5));
	}
}
