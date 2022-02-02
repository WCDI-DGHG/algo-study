/*
BAEKJOON
7568번_덩치
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int count = Integer.parseInt(br.readLine());
		
		int[] height = new int[count];
		int[] weight = new int[count];
		
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < count; i++) {
			int rank = 1;
			
			for (int n = 0; n < count; n++) {
				if (i == n) continue;
				
				if (weight[i] < weight[n]) {
					if (height[i] < height[n]) {
						rank++;
					}
				}
			}
			
			bw.write(rank + " ");
		}
		
		
		bw.flush();
		bw.close();
	}

}
