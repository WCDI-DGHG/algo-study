/*
BAEKJOON
4344번_평균은 넘겠지
Code_By_Goun
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int count = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			
			double avg = 0;
			int[] scores = new int[num];
			
			for (int m = 0; m < num; m++) {
				scores[m] = Integer.parseInt(st.nextToken());
				avg += scores[m];
			}
			avg = avg / num;
			
			int over = 0;
			for (int n = 0; n < num; n++) {
				if (scores[n] > avg) {
					over++;
				}
			}
			bw.write(String.format("%.3f", ((double) over / num) * 100) + "%\n");
		}
		
		bw.flush();
		bw.close();
	}
}
