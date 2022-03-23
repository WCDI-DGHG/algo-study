/*
BAEKJOON
다이나믹 프로그래밍
2579번_계단 오르기
Code_By_Goun
*/

/*
 *	S1 = a1
 *	S2 = a1 + a2
 *	S3 = max(a1 + a3, a2 + a3)
 *
 *	S4 = max(S1 + a3 + a4, S2 + a4)
 *	S5 = max(S2 + a4 + a5, S3 + a5)
 *	S6 = max(S3 + a5 + a6, S4 + a6)
 *	=> max(S[n-3] + a[n-1] + a[n], S[n-2] + a[n])
 *	=> max(S[n-3] + a[n-1], S[n-2]) + a[n]
 */

import java.io.*;

public class Main {
	
	static int[] stairs;
	static Integer dp[];
	
	public static int up(int num) {
		
		if (num == 1) {
			dp[num] = stairs[1];
		}

		if (num >= 2 && dp[num] == null) {
			dp[num] = Math.max(up(num - 3) + stairs[num-1], up(num-2)) + stairs[num];
		}
		
		return num > 0 ? dp[num] : 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		stairs = new int[count + 1];
		dp = new Integer[count + 1];
		
		for (int i = 1; i <= count; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = stairs[0];
		dp[1] = stairs[1];
		
		System.out.println(up(count));
	}

}


