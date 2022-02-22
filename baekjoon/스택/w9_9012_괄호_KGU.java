/*
BAEKJOON
스택
9012번_괄호
Code_By_Goun
*/

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	public static String VPS(String str) {
		Deque<Character> stack = new LinkedList<Character>();

		int len = str.length();
		for (int i = 0; i < len; i++) {
			
			if(stack.isEmpty() || stack.peekLast() == str.charAt(i) || stack.peekLast() == ')') {
				stack.offer(str.charAt(i));
			} else {
				stack.pollLast();
			}
		}
		
		if (stack.isEmpty()) return "YES";
		return "NO";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			bw.write(VPS(br.readLine()) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
