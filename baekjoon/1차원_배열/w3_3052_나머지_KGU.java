/*
BAEKJOON
3052번_나머지
Code_By_Goun
*/

// 방법1- 문제점: 배열의 크기가 너무 큼 -> 메모리 낭비라고 생각함
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[42];
		
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num % 42]++;
		}
		
		int count = 0;
		for (int i = 0; i < 42; i++) {
			if (arr[i] != 0) {
				count++;
			}
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
}

// 방법2 - 메모리 낭비 해결하려고 했지만 오히려 메모리 소모는 조금 더 많음, 시간은 동일
import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[10];
		
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num % 42;
		}
		Arrays.sort(arr);
		
		int count = 1;
		for (int i = 1; i < 10; i++) {
			if (arr[i-1] != arr[i]) {
				count++;
			}
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
}