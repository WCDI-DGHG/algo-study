/*
BAEKJOON
14681번_사분면 고르기
Code_By_Goun
*/
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		char str = '0';
		
		if(x > 0 && y > 0) {
			str = '1';
		} else if (x < 0 && y > 0) {
			str = '2';
		} else if (x < 0 && y < 0) {
			str = '3';
		} else {
			str = '4';
		}
		
		bw.write(str);
		
		bw.flush();
		bw.close();
	}
}