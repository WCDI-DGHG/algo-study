/*
BAEKJOON
1152번_단어의 개수
Code_By_Goun
*/

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		if(word.equals(" ")) {
			System.out.println(0);
		} else {
			String[] wordArr = word.trim().split(" ", -1);
			System.out.println(wordArr.length);
		}
	}
}