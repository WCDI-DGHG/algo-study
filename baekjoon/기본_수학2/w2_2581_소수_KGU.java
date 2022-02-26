/*
BAEKJOON
2581번_소수
Code_By_Goun
*/

/*
문제 풀기위한 수학적 지식
자연수 K가 소수이기 위해서는 K의 제곱근보다 크지 않는 어떤 수로도 나누어지지 않는다.

제곱근 메소드: Math.sqrt();
*/

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int min = num2;
		int total = 0;
		
		while (num1 <= num2) {
			if (num1 == 1) {
				num1++;
				continue;
			}
			
			boolean isPNum = true;	// 소수일 경우 = true
			for (int i = 2; i <= Math.sqrt(num1); i++) {
				if(num1 % i == 0) {	// 소수가 아님
					isPNum = false;
				}
			}
			
			if (isPNum == true) {
				min = (num1 < min) ? num1: min;
				total += num1;
			}
			num1++;
		}
		
		if (total != 0) {
			bw.write(total + "\n" + min);
		} else {
			bw.write("-1");
		}
		
		bw.flush();
		bw.close();
	}
}

