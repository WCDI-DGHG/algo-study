/*
BAEKJOON
수학
2745번_팩토리얼 진법
Code_By_Goun
*/

import java.io.*;

public class Main {
	
	public static int Fectorial(int num, int n) {
		if (n <= 1) return num * 1;
		else return Fectorial(num, n - 1) * n;
	}

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 	 
		 while(true) {
			 int num = Integer.parseInt(br.readLine());
			 if (num == 0) break;
			 
			 int i = 1, sum = 0;
			 while (num > 0) {
				 sum += Fectorial(num % 10, i++);
				 num /= 10;
			 }
			 bw.write(sum + "\n");
		 }
		 bw.flush();
		 bw.close();
	}
}
