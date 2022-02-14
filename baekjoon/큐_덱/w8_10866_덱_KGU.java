/*
BAEKJOON
큐_덱
10866번_덱
Code_By_Goun
*/

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> deque = new LinkedList<Integer>();
		
		int num = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < num; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			switch(st.nextToken()) {
			case "push_front":
				deque.offerFirst(Integer.parseInt(st.nextToken()));
				break;
				
			case "push_back":
				deque.offerLast(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop_front":
				if (!deque.isEmpty()) {
					bw.write(deque.poll()+"\n");
				} else {
					bw.write("-1\n");
				}
				break;
			
			case "pop_back":
				if (!deque.isEmpty()) {
					bw.write(deque.pollLast()+"\n");
				} else {
					bw.write("-1\n");
				}
				break;
				
			case "size":
				bw.write(deque.size()+"\n");
				break;
				
			case "empty":
				if (deque.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				break;
				
			case "front":
				if (!deque.isEmpty()) {
					bw.write(deque.peekFirst()+"\n");
				} else {
					bw.write("-1\n");
				}
				break;
			
			case "back":
				if (!deque.isEmpty()) {
					bw.write(deque.peekLast()+"\n");
				} else {
					bw.write("-1\n");
				}
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}