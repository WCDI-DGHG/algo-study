/*
BAEKJOON
10952번_A+B-5
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean end = false;
		
		while(!end) {
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			if (num1 == 0 && num2 == 0) {
				end = true;
			} else {
				bw.write(num1 + num2 + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

}
