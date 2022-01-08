/*
BAEKJOON
2557번_Hello World
Code_By_Goun
*/

import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write("Hello World!");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}