/*
BAEKJOON
3079번_입국심사
Code_By_Goun
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] times;
	
	static long findMinTime(int N, long M) {
		long low = 0;
		long high = times[N - 1] * M;
		long min = Long.MAX_VALUE;
		
		while (low <= high) {
			long mid = (low + high) / 2;
			long sum = 0;

			for (int time : times) {
				
				if (sum >= M) break;
				sum += mid / time;
			}
			
			if (sum >= M) {
				min = Math.min(min, mid);
				high = mid - 1;
			} else if (sum < M) {
				low = mid + 1;
			}
		}
		
		return min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		times = new int[N];
		
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(times);

		System.out.println(findMinTime(N, M));
	}

}

