/*
BAEKJOON
2292번_벌집
Code_By_Goun
*/

/*
문제 풀기위한 풀이
숫자 N으로 가기위해 지나는 블록 개수
     1 	-> 1개	: 1개의 방만 지나가는 루트 1개	-> 1 + (6 * 0)
   2~7 	-> 2개	: 2개의 방만 지나가는 루트 6개	-> 1 + (6 * 1)
  8~19	-> 3개	: 3개의 방만 지나가는 루트 12개	-> 1 + (6 * 1) + (6 * 2)
 20~37	-> 4개	: 4개의 방만 지나가는 루트 18개	-> 1 + (6 * 1) + (6 * 2) + (6 * 3)
 38~61	-> 5개	: 5개의 방만 지나가는 루트 24개	-> 1 + (6 * 1) + (6 * 2) + (6 * 3) + (6 * 4)
	:						= 1 + 6(1 + 2 + 3 + 4)
	:						= 1 + 6(1~n까지 합)-> 1~n까지 합 = (n*(n+1)) / 2
 -> 1제외 루트가 6씩 증가					= 1 + 3(n * (n + 1))
*/			

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int blockNum = 0;
		int n = 1;
		
		if (num == 1) {
			blockNum = 1;
		} else {
			while (num > blockNum) {
				blockNum = 1 + 3 * (n * (n + 1));
				n++;
			}
		}
		
		bw.write(n + "");
		bw.flush();
		bw.close();
	}
}
