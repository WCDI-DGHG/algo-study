/*
BAEKJOON
수학_해시
15829번_Hashing
Code_By_Goun
*/

/*
	※ mod 특징
	(A+B) mod C = (A mod C + B mod C) mod C
	(A-B) mod C = (A mod C - B mod C) mod C
	(A*B) mod C = (A mod C * B mod C) mod C
	
	따라서 H = ∑ar mod M = ∑((a mod M) * (r mod M)) mod M
*/

/*
	50점 나온 이유(주의할점)
	1. int 범위를 넘어감 -> long 사용
	2. Math.pow(31, n) 사용 시 50점만 나옴. 곱하기를 이용할 것
*/

// 첫 풀이: 50점
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = 1234567891;
		int len = Integer.parseInt(br.readLine());
		
		long sum = 0;
		for (int n = 0; n < len; n++) {
			int num = br.read() - 'a' + 1;
			long r = ((long) Math.pow(31, n)) % M;
			sum += ((num % M) * (r % M)) % M;
		}
		bw.write(sum % M+"");
		bw.flush();
		bw.close();
	}
}

// 최종(100점)
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = 1234567891;
		int len = Integer.parseInt(br.readLine());
		
		long r = 1;
		long sum = 0;
		for (int n = 0; n < len; n++) {
			int num = br.read() - 'a' + 1;
			sum += ((num % M) * (r % M)) % M;
			r = (r * 31) % M;
		}
		bw.write(sum % M+"");
		bw.flush();
		bw.close();
	}
}
