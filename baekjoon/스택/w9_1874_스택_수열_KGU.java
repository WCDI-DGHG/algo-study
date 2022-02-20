/*
BAEKJOON
스택
1874번_스택 수열
Code_By_Goun
*/

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int count = Integer.parseInt(br.readLine());
		int[] arr = new int[count];
		
		for(int i =0; i < count; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Deque<Integer> stack = new LinkedList<>();
		int index = 0;
		int num = 1;
		
		while (index < count) {
			if (stack.isEmpty()) {
				stack.offerLast(num++);
				sb.append("+\n");
				continue;
			}
			if(stack.peekLast() == arr[index]) {
				stack.pollLast();
				index++;
				sb.append("-\n");
			} else {
				stack.offerLast(num++);
				sb.append("+\n");
			}
			if (num > count + 1) break;
		};
		
		if (!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			System.out.println(sb.toString());
		}
	}
}
