/*
BAEKJOON
1920번_수 찾기
Code_By_Goun
*/

import java.io.*;
import java.util.*;

public class Main {
	
	public static boolean find(int[] arr, int num) {
		int left = 0, right = arr.length - 1;
		int mid = 0;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] == num){
				return true;
			} else if (arr[mid] > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = null;
		StringTokenizer st2 = null;
		
		// 입력값 모두 받기
		int count1 = Integer.parseInt(br.readLine());
		int[] arr1 = new int[count1];
		st1 = new StringTokenizer(br.readLine());
		
		int count2 = Integer.parseInt(br.readLine());
		int[] arr2 = new int[count2];
		st2 = new StringTokenizer(br.readLine());
		
		// 첫번째 입력값 배열에 할당
		for (int i = 0; i < count1; i++) {
			arr1[i] = Integer.parseInt(st1.nextToken());
		}

		// 중복 제거한 배열 정렬
		Arrays.sort(arr1);
		
		for (int i = 0; i < count2; i++) {
			// 두번째 입력값 배열에 할당
			arr2[i] = Integer.parseInt(st2.nextToken());
			
			// 동일한 값 유무 찾기
			if(find(arr1, arr2[i])) {
				bw.write("1");
			} else {
				bw.write("0");
			}
			if (i != (count2 - 1)) {
				bw.write("\n");
			}
		}

		bw.flush();
		bw.close();
	}

}
