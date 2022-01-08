/*
BAEKJOON
10718번_We love krii
Code_By_Goun
*/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write("강한친구 대한육군\n강한친구 대한육군");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
