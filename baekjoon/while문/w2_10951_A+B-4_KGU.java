/*
BAEKJOON
10951번_A+B-4
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		String str;
		
		while((str = br.readLine()) != null) {
			
			st = new StringTokenizer(str);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			bw.write(num1 + num2 + "\n");
			
		}
		
		bw.flush();
		bw.close();
	}

}
