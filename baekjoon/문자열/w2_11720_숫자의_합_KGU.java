/*
BAEKJOON
11720번_숫자의 합
Code_By_Goun
*/

// 방법1
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum = 0;
		
		String[] nums = str.split("");
		
		for (int i = 0; i < num; i++) {
			sum += Integer.parseInt(nums[i]);
		}
		
		bw.write(sum + "");

		bw.flush();
		bw.close();
	}
}

// 방법2
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		 
        for (int i = 0; i < num; i++) {
            sum += br.read() - '0';
        }
         
		bw.write(sum + "");

		bw.flush();
		bw.close();
	}
}

