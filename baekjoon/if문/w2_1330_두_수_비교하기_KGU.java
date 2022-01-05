/*
BAEKJOON
1330번_두 수 비교하기
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
			
		if (num1 < num2) {
			bw.write("<");
		} else if (num1 > num2) {
			bw.write(">");
		} else {
			bw.write("==");
		}
		
		bw.flush();
		bw.close();

	}

}

