/*
BAEKJOON
17298번_오큰수
Code_By_Goun
*/

/*
알고리즘 설명
[3, 5, 2, 7]
stack의 원소: 입력 배열의 인덱스

					세번째 원소가 peek()보다 
	첫번째 원소이므로 push()		작으므로 push()	
  |    |		|     |		|     |		|     |		
  |    |		|     |		|     |		|     |		
  |    |	-> 	|     |	->	|     |	->	|  2  |
  |    |		|  0  |		|  1  |		|  1  |
  ㅡㅡ		 ㅡㅡ		 ㅡㅡ		 ㅡㅡ
			두번째 원소 5가 첫번째 원소 3(peek())
			보다 크므로 pop()하고 push()
			(인덱스 0의 값을 5로 변경함)

네번째 원소가 peek()보다
크므로 pop()하고 해당 인덱스의 값을
네번째 원소값으로 변경
  |     |			|      |			네번째 원소가 마지막 인덱스이므로
  |     |			|      |			보다 큰 수가 존재x
  |     |		-> 	|      |	 	-> 	값을 -1로 변경함.
  |  1  |			|  0  |		
   ㅡㅡ		 	ㅡㅡ	
			네번째 원소가 peek()보다 크므로 
			pop()하고 해당 인덱스의 값을 
			네번째 원소값으로 변경함	
*/

import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		String[] nums = new String[count];
		nums = br.readLine().split(" ");
		
		Stack<Integer> stack = new Stack();
		int[] result = new int[count];
		for (int i = 0; i < count; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
			} else {
				int num = Integer.parseInt(nums[i]);
				if(Integer.parseInt(nums[stack.peek()]) >= num) {
					stack.push(i);
				} else {
					result[stack.pop()] = num;
					i--;
				}
			}
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		
		for (int num : result) {
			bw.write(num + " ");
		}
		
		bw.flush();
		bw.close();
	}

}
