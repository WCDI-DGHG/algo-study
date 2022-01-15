/*
BAEKJOON
1000번_A+B
Code_By_Goun
*/


import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int numA = br.read() - '0';
		br.read();
		int numB = br.read() - '0';
		
		bw.write(numA + numB + "");
		bw.flush();
		bw.close();
	}
}