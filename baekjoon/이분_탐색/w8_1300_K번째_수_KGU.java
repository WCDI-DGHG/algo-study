/*
BAEKJOON
이분 탐색
1300번_K번째 수
Code_By_Goun
*/

import java.io.*;

public class Main {
	
	public static int findK(int n, int k) {
		int left = 1, right = k;

		while (left < right) {
			int mid = (left + right) / 2;
			int count = 0;
			
			for (int i = 1; i <= n; i++) {
				count += Math.min(mid / i, n);
			}
		
			if (k <= count) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		bw.write(findK(n, k) + "");
		
		bw.flush();
		bw.close();
	}

}
