/*
BAEKJOON
재귀함수
11729번_하노이 탑 이동 순서
Code_By_Goun
*/

import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	
	public static void hanoi(int num, int start, int mid, int end) {
		if(num == 1) {
			sb.append(start + " " + end + "\n");
			count++;
			return;
		}
		
		hanoi(num - 1, start, end, mid);
		sb.append(start + " " + end + "\n");
		count++;
		hanoi(num - 1, mid, start, end);
			
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		hanoi(num, 1, 2, 3);
		System.out.println(count);
		System.out.println(sb.toString());
		
		scan.close();
	}
}