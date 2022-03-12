/*
BAEKJOON
DFS와 BFS
7576번_토마토
Code_By_Goun
*/

import java.io.*;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static int BFS(int col, int row, boolean[][] arr, Deque<Map<Character, Integer>> queue) {
		int[] x = {-1, 1, 0, 0};	// 좌, 우, 상, 하
		int[] y = {0, 0, 1, -1};	// 좌, 우, 상, 하
		int count = 0;
		int day = -1;
		
		while(!queue.isEmpty()) {
			Map<Character, Integer> map = queue.poll();
			
			if (count == 0) {
				day++;
				count = queue.size();
			} else {
				count--;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = map.get('r') + x[i];
				int nextY = map.get('c') + y[i];
				
				// 범위밖
				if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) {
					continue;
				}
				
				if(arr[nextX][nextY]) continue;
				
				arr[nextX][nextY] = true;
				Map<Character, Integer> m = new HashMap<Character, Integer>();
				m.put('r', nextX);
				m.put('c', nextY);
				queue.add(m);
			}
		}
		 
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (!arr[r][c]) return -1;
			}
		}
		
		return day;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[row][col];
		
		Deque<Map<Character, Integer>> queue = new LinkedList<>();
		
		for (int r = 0; r < row; r++) {		
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < col; c++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1) {
					arr[r][c] = true;
				} else if (num == 1) {
					Map<Character, Integer> map = new HashMap<Character, Integer>();
					map.put('r', r);
					map.put('c', c);
					arr[r][c] = true;
					queue.add(map);
				}
			}
		}
		int num = BFS(col, row, arr, queue);
		System.out.println(num);
	}

}
