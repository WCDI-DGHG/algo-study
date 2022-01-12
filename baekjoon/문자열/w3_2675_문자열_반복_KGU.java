/*
BAEKJOON
2675번_문자열 반복
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder strb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < count; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int num = Integer.parseInt(st.nextToken());
			String testcase = st.nextToken();
			int len = testcase.length();
			
			for (int m = 0; m < len; m++) {
				for (int n = 0; n < num; n++) {
					strb.append(testcase.charAt(m));
				}
			}
			strb.append("\n");
		}
		
		bw.write(strb.toString());
		bw.flush();
		bw.close();
	}
}