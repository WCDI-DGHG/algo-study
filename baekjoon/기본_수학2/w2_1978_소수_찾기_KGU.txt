/*
BAEKJOON
1978번_소수 찾기
Code_By_Goun
*/

/*
문제 풀기위한 수학적 지식
자연수 K가 소수이기 위해서는 K의 제곱근보다 크지 않는 어떤 수로도 나누어지지 않는다.

제곱근 메소드: Math.sqrt();
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int count = Integer.parseInt(br.readLine());
		String str = br.readLine();
		st = new StringTokenizer(str);
		
		int cnt = 0;
		for(int i = 0; i < count; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean isP = true;
			
			if(num == 1) continue;
			
			for(int m = 2; m <= Math.sqrt(num); m++) {
				if (num % m == 0) {
					isP = false;
				}
			}
			
			if(isP) {
				cnt++;
			}
		}
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}
