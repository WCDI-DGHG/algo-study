/*
BAEKJOON
큐_덱
1021번_회전하는 큐
Code_By_Goun
*/

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 세팅
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		int[] mArr = new int[M];
		for(int a = 0; a < M; a++) {
			mArr[a] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		// 회전하는 큐 시작
		int first = 0, last = N - 1;
		int count = 0;
		int index = 0;
		while (index < M) {
			int target = mArr[index];
			if(target == queue.peek()) {
				queue.poll();
				index++;
			} else {
				int target_index = queue.indexOf(mArr[index]);
				if(target_index > queue.size() / 2) {
					while(queue.peek() != target) {
						queue.offerFirst(queue.pollLast());
						count++;
					}
				} else {
					while(queue.peek() != target) {
						queue.offer(queue.poll());
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
