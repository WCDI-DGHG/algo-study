/*
BAEKJOON
이분 탐색
1654번_랜선 자르기
Code_By_Goun
*/

import java.io.*;
import java.util.Arrays;

public class Main {
	
	public static long cut(int n, int k, int[] lines) {
		long left = 1, right = lines[k - 1];
		long mid = 0;
		
		while(left <= right) {
			long count = 0;
			mid = (left + right) / 2;
			
			for (int i = 0; i < k; i++) {
				count += (lines[i] / mid);
			}
			
			if(count < n) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int k = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		
		int[] lines = new int[k];
		for (int i = 0; i < k; i++) {
			lines[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lines);
		System.out.println(cut(n, k, lines));
	}

}