/*
BAEKJOON
2884번_알람 시계
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if (m < 45) {
			if ((h -= 1) < 0) {
				h = 23;
			}
			m = 60 + (m - 45);
		} else {
			m -= 45;
		}
		
		bw.write(h+" "+m);
		
		bw.flush();
		bw.close();
	}
}