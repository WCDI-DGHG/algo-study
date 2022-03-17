/*
BAEKJOON
재귀함수
2447번_별 찍기 - 10
Code_By_Goun
*/

import java.util.Scanner;

public class Main {	
	static char[][] stars;
	
	public static void stamp(int x, int y, int N, boolean blank) {
		int size = N / 3;
		int count = 0;
		
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					stars[i][j] = ' ';
				}
			}
			return;
		}
		
		if (N == 1) {
			stars[x][y] = '*';
			return;
		}
		for (int row = x; row < x + N; row += size) {
			for (int col = y; col < y + N; col += size) {
				count++;
				if (count == 5) {
					stamp(row, col, size, true);
				} else {
					stamp(row, col, size, false);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		stars = new char[N][N];
		stamp(0, 0, N, false);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(stars[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

}
