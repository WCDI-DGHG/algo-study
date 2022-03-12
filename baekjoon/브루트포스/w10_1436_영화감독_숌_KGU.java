/*
BAEKJOON
브루트포스(완전탐색)
1436번_영화감독 숌
Code_By_Goun
*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int num = 666;
		int count = 1;
		
		while (count < N) {
			num++;
			
			if (String.valueOf(num).contains("666")) 
				count++;
		}
		
		System.out.println(num);
	}
}