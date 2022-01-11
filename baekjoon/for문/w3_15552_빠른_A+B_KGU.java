/*
BAEKJOON
15552번_빠른 A+B
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String result = "";
		int count = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < count; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			bw.write(num1 + num2 + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}


