/*
BAEKJOON
DFS와 BFS
2606번_바이러스
Code_By_Goun
*/

/*
풀이 참고
    1  2  3  4  5  6  7
1  0  1  0  0	 1  0  0 
2  1  0  1  0	 1  0  0
3  0  1  0  0	 0  0  0 
4  0  0  0  0	 0  0  1 
5  1  1  0  0	 0  1  0 
6  0  0  0  0	 1  0  0 
7  0  0  0  1	 0  0  0 
*/

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int numOfCom, connected;
	static int[][] arr;
	static boolean[] infected;
	
	public static int BFS() {
		int count = -1;
		Deque<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(1);
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			if(infected[now]) {
				continue;
			}
			infected[now] = true;
			count++;
			
			for (int i = 1; i <= numOfCom; i++) {
				if (arr[now][i] == 1 && infected[i] == false) {
					queue.offer(i);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		numOfCom = Integer.parseInt(br.readLine());
		connected = Integer.parseInt(br.readLine());
		arr = new int[numOfCom + 1][numOfCom + 1];
		infected = new boolean[numOfCom + 1];
		Arrays.fill(infected, false);
		
		for (int i = 1; i <= connected; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
		
			arr[com1][com2] = 1;
			arr[com2][com1] = 1;
		}
		
		bw.write(BFS() + "");
		bw.flush();
		bw.close();
	}
}
