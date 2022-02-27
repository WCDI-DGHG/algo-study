/*
BAEKJOON
수학
2745번_진법 변환
Code_By_Goun
*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String num1 = scan.next();
		int num2 = scan.nextInt();
		
		System.out.println(Integer.parseInt(num1, num2));
	}

}
