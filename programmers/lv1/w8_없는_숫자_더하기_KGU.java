/* 
Programmers
없는 숫자 더하기
Code_By_Goun
*/

class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        int sum = 0;
        int len = numbers.length;
        
        for (int i = 0; i < len; i++) {
        	sum += numbers[i];
        }
        
        answer = 45 - sum;
        return answer;
    }
}

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers1 = {1, 2, 3, 4, 6, 7, 8, 0};
		System.out.println(s.solution(numbers1));
		
		int[] numbers2 = {5, 8, 4, 0, 6, 7, 9};
		System.out.println(s.solution(numbers2));
	}
}

