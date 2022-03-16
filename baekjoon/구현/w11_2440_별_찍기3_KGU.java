/*
BAEKJOON
구현
2440번_별 찍기 - 3
Code_By_Goun
*/
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuffer str = new StringBuffer();
		
		int num = scan.nextInt();
		
		for (int y = 0; y < num; y++) {
			for (int x = num - y; x > 0; x--) {
				str.append("*");
			}
			str.append("\n");
		}
		System.out.println(str.toString());	
	}
}

