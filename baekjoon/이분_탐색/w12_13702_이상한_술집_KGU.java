/*
BAEKJOON
13702번_이상한 술집
Code_By_Goun
*/

import java.io.*;
import java.util.Arrays;

public class Main {
	
	public static Long div(int[] ml, int N, int K) {
		long left = 0;
		long right = ml[N - 1];
		long mid = 0;
		
		while (left <= right) {
			mid = (left + right) / 2;
			int cnt = 0;

			for (int n = 0; n < N; n++) {
				cnt += (mid > 0) ? ml[n] / mid : ml[n] / 1;
			}
			
			if (cnt < K) {
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
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int[] ml = new int[N];
		
		for (int i = 0; i < N; i++) {
			ml[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ml);
		
		System.out.println(div(ml, N, K));
	}
}
