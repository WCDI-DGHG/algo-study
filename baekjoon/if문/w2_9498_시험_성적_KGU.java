/*
BAEKJOON
9498번_시험 성적
Code_By_Goun
*/

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int score = Integer.parseInt(br.readLine());
		
		if (score >= 90) {
			bw.write("A");
		} else if (score >= 80) {
			bw.write("B");
		} else if (score >= 70) {
			bw.write("C");
		} else if (score >= 60) {
			bw.write("D");
		} else {
			bw.write("F");
		}
		
		bw.flush();
		bw.close();
	}

}
