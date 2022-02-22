/*
BAEKJOON
큐_덱
1966번_프린터 큐
Code_By_Goun
*/

import java.io.*;
import java.util.*;

public class Main {

	private static int printer(int findDoc, Deque<int[]> queue, int[] impo) {
		int count = 0;
		int index = queue.size() - 1;
		while(!queue.isEmpty()) {
			int[] num = queue.poll();
			
			if (num[1] != impo[index]) {
				queue.offer(num);
			} else {
				index--;
				count++;
				
				if(num[0] == findDoc) return count;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int count = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			
			int numOfDoc = Integer.parseInt(st.nextToken());
			int findDoc = Integer.parseInt(st.nextToken());
			Deque<int[]> queue = new LinkedList<>();
			int[] impo = new int[numOfDoc];
			
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < numOfDoc; n++) {
				int num = Integer.parseInt(st.nextToken());
				queue.offer(new int[] {n, num});	// key값: 중요도, value값: 순서
				impo[n] = num;
			}
			Arrays.sort(impo);
			
			System.out.println(printer(findDoc, queue, impo));
		}
	}
}
