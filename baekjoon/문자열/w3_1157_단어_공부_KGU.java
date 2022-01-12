/*
BAEKJOON
1157번_단어 공부
Code_By_Goun
*/

import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		str = str.toUpperCase();
		char[] strings = str.toCharArray();
		Arrays.sort(strings);
		
		int max = 0, count = 1, maxCount = 0;
		char word = '0';
		for (int i = 1; i <= strings.length; i++) {
			if (i != strings.length && strings[i - 1] == strings[i]) {
				count++;
			} else {
				if (max < count) {
					max = count;
					word = strings[i-1];
					maxCount = 1;
				} else if (max == count) {
					maxCount++;
				}
				count = 1;
			}
		}
		
		if (maxCount != 1) {
			bw.write("?");
		} else {
			bw.write(word);
		}
		
		bw.flush();
		bw.close();
	}
}