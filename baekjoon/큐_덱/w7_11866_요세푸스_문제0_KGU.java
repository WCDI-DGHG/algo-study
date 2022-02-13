/*
BAEKJOON
큐_덱
11866번_요세푸스 문제0
Code_By_Goun
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<>();
		StringBuffer str = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= count; i++) {
			queue.offer(i);
		}
		
		str.append("<");
		while (!queue.isEmpty()) {
			
			for (int n = 1; n < num; n++) {
				queue.offer(queue.poll());
			}
			str.append(queue.poll());
			
			if(!queue.isEmpty()) {
				str.append(", ");
			}
		}
		str.append(">");
		
		bw.write(str.toString());
		bw.flush();
		bw.close();
	}
}
