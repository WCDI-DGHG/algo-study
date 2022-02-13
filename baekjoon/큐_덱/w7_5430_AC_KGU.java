/*
BAEKJOON
큐_덱
5430번_AC
Code_By_Goun
*/

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	static boolean front = true;
	static Deque<Integer> deque = new LinkedList<>();
	
	public static void R() {
		front = !front;
	}
	
	public static boolean D() {
		if(deque.isEmpty()) return false;

		if(front) {
			deque.poll();
		} else {
			deque.pollLast();
		}
		return true;
	}

	public static StringBuffer printAll(StringBuffer str) {
		
		str.append("[");
		
		if (front == true) {
			while (!deque.isEmpty()) {
				str.append(deque.poll());
				if(deque.peekFirst()!=null)
					str.append(",");
			}
		} else {
			while (!deque.isEmpty()) {
				str.append(deque.pollLast());
				if(deque.peekFirst()!=null)
					str.append(",");
			}
		}
		
		str.append("]");
		return str;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer str = new StringBuffer();
		
		int count = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < count; i++) {
			deque.clear();
			front = true;
			String fun = br.readLine();
			int arrLen = Integer.parseInt(br.readLine());
			String arrS = br.readLine().replace('[', ',').replace(']', ',');
			String[] arr = arrS.split(",");
			
			for (int n = 1; n <= arrLen; n++) {
				deque.add(Integer.parseInt(arr[n]));
			}

			boolean error = false;

			for (int m = 0; m < fun.length(); m++) {
				if (fun.charAt(m) == 'R') {
					R();
				}
				else if (fun.charAt(m) == 'D') {					
					if (error = !D()) break;
				}
			}

			
			if (error) {
				str.append("error");
			} else {
				str = printAll(str);
			}
			
			if (i != count-1) str.append("\n");
		}
		
		bw.write(str.toString());
		bw.flush();
		bw.close();
	}
}
