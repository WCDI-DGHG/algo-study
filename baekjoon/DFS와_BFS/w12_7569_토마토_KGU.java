/*
BAEKJOON
DFS와 BFS
7569번_토마토
Code_By_Goun
*/

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static boolean[][][] arr;
	
	public static int BFS(int col, int row, int H, Deque<int[]> queue) {
		int[] x = {-1, 1, 0, 0, 0, 0};	// 좌, 우, 상, 하, 위(z축), 아래(z축)
		int[] y = {0, 0, 1, -1, 0, 0};	// 좌, 우, 상, 하, 위(z축), 아래(z축)
		int[] z = {0, 0, 0, 0, 1, -1};	// 좌, 우, 상, 하, 위(z축), 아래(z축)
		int count = 0;
		int day = -1;
		
		while(!queue.isEmpty()) {
			int[] box = queue.poll();
			
			if (count == 0) {
				day++;
				count = queue.size();
			} else {
				count--;
			}

			for (int i = 0; i < 6; i++) {
				// 0: H, 1: row, 2: col
				int nextX = box[1] + x[i];
				int nextY = box[2] + y[i];
				int nextZ = box[0] + z[i];
				
				// 범위밖
				if (nextX < 0 || nextY < 0 || nextZ < 0 ||
					nextX >= row || nextY >= col || nextZ >= H) {
					continue;
				}
				
				if(arr[nextZ][nextX][nextY]) continue;
				
				arr[nextZ][nextX][nextY] = true;
				int[] b = {nextZ, nextX, nextY};
				queue.add(b);
			}
		}
		 
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (!arr[h][r][c]) return -1;
				}
			}
		}
		
		return day;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		arr = new boolean[H][row][col];
		
		Deque<int[]> queue = new LinkedList<>();	// 0: H, 1: row, 2: col

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < row; r++) {		
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < col; c++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == -1) {
						arr[h][r][c] = true;
					} else if (num == 1) {
						int[] box = {h, r, c};
						arr[h][r][c] = true;
						queue.add(box);
					}
				}
			}
		}
		int num = BFS(col, row, H, queue);
		System.out.println(num);
	}
}
