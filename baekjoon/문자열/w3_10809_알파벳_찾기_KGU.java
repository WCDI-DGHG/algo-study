/*
BAEKJOON
10809번_알파벳 찾기
Code_By_Goun
*/

import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1);
		String word = br.readLine();
		
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i);
			c = c % 97;
			if (alphabet[c] == -1) {
				alphabet[c] = i;
			}
		}

		for (int i = 0; i < 26; i++) {
			bw.write(alphabet[i] + " ");
		}

		bw.flush();
		bw.close();
	}
}