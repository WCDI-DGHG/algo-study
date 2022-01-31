/* 
소수 찾기
알고리즘_완전 탐색
Code_By_Goun
*/
/*
생각한 구현 알고리즘

f(1, 2345)
12 13 14 15
f({} ,2345)
123 124 125 132 134 135 142 143 145 152 153 154
f({}, 2345)
1234 1235 1243 1245 1253 1254 1324 1325 1342 1345 1352 1354

f(2, 1345)
21 23 24 25
*/

class Solution5 {
	public int count;
	
	public void checkIsPrime(int number) {
//		System.out.println(number);
		
		if (number < 2) {
			return;
		} else if (number == 2) {
			count++;
			return;
		}
		
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return;
			}
		}
		
		count++;
		return;
	}
	
	public void makeNumber(String num, String nums) {
		String newNum = "";
		int len = nums.length();
		
		checkIsPrime(Integer.parseInt(num));
		System.out.println(num + "\t" + nums);
		
		if(len > 0) {
			for (int i = 0; i < len; i++) {
				newNum = num;
				newNum += nums.charAt(i);
//				
//				checkIsPrime(Integer.parseInt(newNum));
				
				nums = nums.substring(0, i) + nums.substring(i + 1);
				makeNumber(newNum, nums);
			}
		}
	}
	
	public int solution(String numbers) {
        int answer = 0;

        int len = numbers.length();
        
        for (int i = 0; i < len; i++) {
        	String nums = numbers.substring(0, i) + numbers.substring(i + 1);
        	makeNumber(numbers.charAt(i)+"", nums);
        }
        
        answer = count;
        
        return answer;
    }
}
public class 소수_찾기 {

	public static void main(String[] args) {
		Solution5 s = new Solution5();
		String numbers = "17";
		System.out.println(s.solution(numbers));
		numbers = "011";
		System.out.println(s.solution(numbers));

	}

}
