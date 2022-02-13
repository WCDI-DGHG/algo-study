/*
BAEKJOON
브루트포스(완전탐색)
2231번_분해합
Code_By_Goun
*/

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i = 1; i < num; i++) {
			int temp = i;
			int sum = i;
			
			while (temp > 0) {
				sum += temp % 10;
				temp /= 10;
			}

			if (sum == num) {
				result = i;
				break;
			}
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}