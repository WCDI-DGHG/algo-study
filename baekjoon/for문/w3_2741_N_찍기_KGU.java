/*
BAEKJOON
2741번_N 찍기
Code_By_Goun
*/

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= count; i++) {
			bw.write(i + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}

