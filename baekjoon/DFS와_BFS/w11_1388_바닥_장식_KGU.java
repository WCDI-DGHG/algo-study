/*
BAEKJOON
DFS와 BFS
1388번_바닥 장식
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] floor = new char[row][col];
		int count = 0;
		
		for (int r = 0; r < row; r++) {
			floor[r] = br.readLine().toCharArray();
			for (int c = 0; c < col; c++) {
				if (floor[r][c] == '-') {
					count++;
					while(c < col && floor[r][c] == '-') {
						c++;
					}
				}
			}
		}
		
		for (int c = 0; c < col; c++) {
			for (int r = 0; r < row; r++) {
				if (floor[r][c] == '|') {
					count++;
					while(r < row && floor[r][c] == '|') {
						r++;
					}
				}
			}
		}
		System.out.println(count);
	}

}
