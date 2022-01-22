/*
BAEKJOON
8948번_OX퀴즈
Code_By_Goun
*/
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		String[] cases = new String[count];
		
		int result = 0, answer = 0;
		for (int i = 0; i < count; i++) {
			String str = br.readLine();
			cases[i] = str;
			
			result = 0;
			answer = 0;
			for (int m = 0; m < cases[i].length(); m++) {
				if (cases[i].charAt(m) == 'O') {
					result += ++answer;
				} else {
					answer = 0;
				}
			}
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}