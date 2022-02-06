/*
BAEKJOON
스택
10773번_제로
Code_By_Goun
*/

import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		
		int count = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < count; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0 && !stack.isEmpty()) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}
 		
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}

}
