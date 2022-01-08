/*
BAEKJOON
10818번_최소, 최대
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		String strNums = br.readLine();
		
		st = new StringTokenizer(strNums);
		int[] nums = new int[count];
		
		int min = 0, max = 0;
		
		for (int i = 0; i < count; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			
			if (i == 0) {
				min = nums[i];
				max = nums[i];
			} else {
				if (nums[i] < min) {
					min = nums[i];
				} else if (nums[i] > max) {
					max = nums[i];
				}
			}
		}
		
		bw.write(min + " " + max);
		bw.flush();
		bw.close();	
	}
}

