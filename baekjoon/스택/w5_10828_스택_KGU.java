/*
BAEKJOON
10828번_스택
Code_By_Goun
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Stack {
	static List<Integer> stack = new ArrayList<Integer>();
	static int index = -1;
	
	public static void push(int x) {
		stack.add(++index, x);
	}
	
	public static int pop() {
		if (empty() == 0) {
			int num = stack.get(index--);
			return num;
		}
		return -1;
	}
	
	public static int size() {
		return index + 1;
	}
	
	public static int empty() {
		if (index != -1) {
			return 0;
		}
		return 1;
	}
	
	public static int top() {
		if (empty() == 0) {
			return stack.get(index);
		}
		return -1;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push": 
				Stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop": 
				bw.write(Stack.pop() + "\n");
				break;
			case "size": 
				bw.write(Stack.size() + "\n");
				break;
			case "empty": 
				bw.write(Stack.empty() + "\n");
				break;
			case "top": 
				bw.write(Stack.top() + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}
}