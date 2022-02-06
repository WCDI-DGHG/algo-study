/*
BAEKJOON
재귀함수
10829번_이진수 변환
Code_By_Goun
*/

/*
알고리즘 분석

이진수 변환
	num					binary							몫을 2로 나눔
	1	->	2^0		=	1		-> 1 % 2 = 1	1 / 2 = 0
	2	->	2^1		=	10		-> 2 % 2 = 0	2 / 2 = 1
	3	->	2^1+2^0		=	11		-> 3 % 2 = 1	3 / 2 = 1
	4	->	2^2		=	100		-> 4 % 2 = 0	4 / 2 = 2		-> 	2 % 2 = 0	2 / 2 = 1	
	5	->	2^2+2^0		=	101		-> 5 % 2 = 1	5 / 2 = 2		-> 	2 % 2 = 0	2 / 2 = 1		
	6	->	2^2+2^1		=	110		-> 6 % 2 = 0	6 / 2 = 3		->	3 % 2 = 1	3 / 2 = 1		
	7	->	2^2+2^1+2^0	=	111		-> 7 % 2 = 1	7 / 2 = 3		->	3 % 2 = 1	3 / 2 = 1		
	8	->	2^3		=	1000		-> 8 % 2 = 0	8 / 2 = 4		->	4 % 2 = 0	4 / 2 = 2		
	9	->	2^3+2^0		=	1001		-> 9 % 2 = 1	9 / 2 = 4		-> 	4 % 2 = 0	4 / 2 = 2		
	10	->	2^3+2^1		=	1010		-> 10 % 2 = 0	10 / 2 = 5	->	5 % 2 = 1	5 / 2 = 2		
	11	->	2^3+2^1+2^0	=	1011		-> 11 % 2 = 1	11 / 2 = 5	->	5 % 2 = 1	5 / 2 = 2		
	12	->	2^3+2^2		=	1100		-> 12 % 2 = 0	12 / 2 = 6	-> 	6 % 2 = 0	6 / 2 = 3		
	13	->	2^3+2^2	+2^0	=	1101		-> 13 % 2 = 1	13 / 2 = 6 	->	6 % 2 = 0	6 / 2 = 3	

=> 몫이 1이될 때까지 몫을 나눔
=> 나머지들이 각 자리 수(일의자리부터)
*/

import java.io.*;

public class Main {

	public static StringBuffer toBinary(Long num, StringBuffer value) {
		
		if (num / 2 == 0) {
			value.insert(0, num%2);
			return value;
		}
	
		return toBinary(num/2, value.insert(0, num % 2));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer str = new StringBuffer();
		 
		bw.write(toBinary(Long.parseLong(br.readLine()), str) + "");
		
		bw.flush();
		bw.close();
	}

}