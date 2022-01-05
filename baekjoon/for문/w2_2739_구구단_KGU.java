/*
BAEKJOON
2739번_구구단
Code_By_Goun
*/

package baekjoon;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < 10; i++) {
			wr.write(num + " * " + i + " = " + (num * i) + "\n");
		}
		
		wr.flush();
		wr.close();
		
	}

}