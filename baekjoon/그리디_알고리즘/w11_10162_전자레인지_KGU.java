/*
BAEKJOON
그리디 알고리즘
10162번_전자레인지
Code_By_Goun
*/

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		int A = 5 * 60;
		int B = 1 * 60;
		int C = 10;
		int[] count = new int[3];
		if (T/A >= 1.0) {
			count[0] += T/A;
			T %= A;
		}
		
		if (T/B >= 1) {
			count[1] += T/B;
			T %= B;
		}
		
		if (T/C >= 1) {
			count[2] += T/C;
			T %= C;
		}

		if(T == 0) {
			bw.write(count[0] + " " + count[1] + " " + count[2]);
		} else {
			bw.write(-1 + "");
		}
		
		bw.flush();
		bw.close();
	}

}


