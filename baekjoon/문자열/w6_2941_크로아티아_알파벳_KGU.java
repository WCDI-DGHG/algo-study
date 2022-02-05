/*
BAEKJOON
2941번_크로아티아 알파벳
Code_By_Goun
*/

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="}; 
		
		String str = br.readLine();

		for (int i = 0; i < cro.length; i++) {
			str = str.replaceAll(cro[i], "0");
		}
		
		bw.write(str.length() + "");
		bw.flush();
		bw.close();
	}

}
