/*
BAEKJOON
10757번_큰 수 A+B
Code_By_Goun
*/

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());
		
		bw.write(A.add(B) + "");
		bw.flush();
		bw.close();
	}
}
