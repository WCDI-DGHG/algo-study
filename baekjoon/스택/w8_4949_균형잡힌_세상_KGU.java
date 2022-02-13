/*
BAEKJOON
스택
4949번_균형잡힌 세상
Code_By_Goun
*/

import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		
		while (true) {
			String str = br.readLine();
			if (".".equals(str)) break;
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '(' || ch == '[') {
					stack.push(ch);
				} else if (ch == ')') {
					if (!stack.isEmpty() && '(' == stack.peek()) {
						stack.pop();
					} else {
						stack.push(ch);
					}
				} else if (ch == ']') {
					if (!stack.isEmpty() && '[' == stack.peek()) {
						stack.pop();
					} else {
						stack.push(ch);
					}
				}
			}
			
			if (stack.isEmpty()) bw.write("yes\n");
			else bw.write("no\n");
			stack.clear();
		}
		
		bw.flush();
		bw.close();
	}
}