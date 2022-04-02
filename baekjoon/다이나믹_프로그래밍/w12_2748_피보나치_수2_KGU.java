/*
BAEKJOON
다이나믹 프로그래밍
2748번_피보나치 수2
Code_By_Goun
*/

import java.io.*;

public class Main {
	
	static Long[] PD;
	
	public static Long fi(int num) {

		if(PD[num] == null) {
			PD[num] = (long) (fi(num - 1) + fi(num - 2));
		}
		
		return PD[num];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		PD = new Long[num+1];
		PD[0] = 0L;
		PD[1] = 1L;
		
		System.out.println(fi(num));
	}

}
