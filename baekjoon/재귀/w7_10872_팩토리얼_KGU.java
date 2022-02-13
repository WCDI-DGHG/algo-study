/*
BAEKJOON
재귀함수
10872번_팩토리얼
Code_By_Goun
*/

import java.io.*;

public class Main {

	public static int factorial(int num) {
		
		if (num == 1 || num == 0) {
			return 1;
		}
		
		return num * factorial(num-1);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(factorial(Integer.parseInt(br.readLine())) + "");
		
		bw.flush();
		bw.close();
	}

}
