/*
BAEKJOON
2577번_숫자의 개수
Code_By_Goun
*/

// 방법1: while문 사용
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int num3 = Integer.parseInt(br.readLine());
		
		int result = num1 * num2 * num3;
		int[] arr = new int[10];
		
		do {
			arr[result%10]++;
		} while ((result /= 10) != 0);
		
		for (int i = 0; i < 10; i++) {
			bw.write(arr[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}

// 방법2: log활용
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int num3 = Integer.parseInt(br.readLine());
		
		int result = num1 * num2 * num3;
		int[] arr = new int[10];
		
		int length = (int)(Math.log10(result)+1);
        for(int i = 0; i < length; i++) {
            arr[result % 10]++;
            result = result/10;
        }
		for (int i = 0; i < 10; i++) {
			bw.write(arr[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}



