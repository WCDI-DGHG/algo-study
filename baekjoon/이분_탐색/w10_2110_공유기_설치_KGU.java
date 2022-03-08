/*
BAEKJOON
2110번_공유기 설치
Code_By_Goun
*/

import java.io.*;
import java.util.Arrays;

public class Main {
	static int cntHome;
	static int cntRouter;
	static int[] homes;
	
	public static int findDis() {
		int min = 1, max = homes[cntHome - 1] - homes[0];
		int mid = 0;
		int answer = 0;
		
		while (min <= max) {
			int count = 1;
			int start = 0;
			mid = (min + max) / 2;
			
			for (int i = 1; i < cntHome; i++) {
				if (homes[i] - homes[start] >= mid) {
					count++;
					start = i;
				}
			}
			
			if (count >= cntRouter) {
				answer = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}
        }
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" ");
		cntHome = Integer.parseInt(line[0]);
		cntRouter = Integer.parseInt(line[1]);
		homes = new int[cntHome];
		
		for (int i = 0; i < cntHome; i++) {
			homes[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(homes);
		
		bw.write(findDis() + "");
		bw.flush();
		bw.close();
	}
}