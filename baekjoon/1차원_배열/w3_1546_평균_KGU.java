/*
BAEKJOON
1546번_평균
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		
		int[] arr = new int[count];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		double max = 0.0, result = 0.0;
		
		for (int i = 0; i < count; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		for (int i = 0; i < count; i++) {
			result += arr[i] / max * 100;
		}
		
		bw.write(result/count + "");
		bw.flush();
		bw.close();
	}
}