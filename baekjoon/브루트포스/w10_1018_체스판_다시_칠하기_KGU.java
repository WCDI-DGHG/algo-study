/*
BAEKJOON
브루트포스(완전탐색)
1018번_체스판 다시 칠하기
Code_By_Goun
*/

import java.io.*;

public class Main {
	
	public static boolean[][] chess;
	public static int min = 64;
	
	private static void findMin(int x, int y) {
		int rowEnd = x + 8;
		int colEnd = y + 8;
		int count = 0;
		
		boolean color = chess[x][y];	// W: true, B: false
		
		for (int i = x; i < rowEnd; i++) {
			for (int j = y; j < colEnd; j++) {
				if (chess[i][j] != color) {
					count++;
				}
				color = !color;
			}
			
			color = !color;
		}
		
		count = Math.min(count, 64 - count);
		min = Math.min(min, count);
	}


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		chess = new boolean[N][M];
		
		for (int n = 0; n < N; n++) {
			String line = br.readLine();
			for (int m = 0; m < M; m++) {
				if (line.charAt(m) == 'W') {
					chess[n][m] = true;
				} else {
					chess[n][m] = false;
				}
			}
		}
		
		int row = N - 7;
		int col = M - 7;
		
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				findMin(x, y);
			}
		}
		System.out.println(min);
	}
}
