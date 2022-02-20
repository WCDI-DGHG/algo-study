/* 
Programmers
자연수 뒤집어 배열로 만들기
Code_By_Goun
*/

import java.util.Arrays;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String str = n+"";
        int len = str.length();
        answer = new int[len];
        System.out.println("길이:" + len);
        
        for (int i = 0; i < len; i++) {
        	answer[i] = (int) (n % 10);
        	n /= 10;
        }
        return answer;
    }
}

public class Main{
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		System.out.println(Arrays.toString(s.solution(12345)));
	}
}
