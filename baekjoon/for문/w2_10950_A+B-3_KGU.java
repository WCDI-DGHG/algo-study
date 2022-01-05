/*
BAEKJOON
10950번_A+B-3
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < count; i++) {
			String nums = br.readLine();
			StringTokenizer st = new StringTokenizer(nums);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			wr.write(num1 + num2 + "\n");
		}
		
		wr.flush();
		wr.close();
		
	}

}

