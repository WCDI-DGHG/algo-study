/*
BAEKJOON
2562번_최댓값
Code_By_Goun
*/

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = 0, maxIndex = 0;
		int[] nums = new int[9];
		
		for (int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i + 1;
			}
		}
		
		bw.write(max + "\n" + maxIndex);
		bw.flush();
		bw.close();
	}
}