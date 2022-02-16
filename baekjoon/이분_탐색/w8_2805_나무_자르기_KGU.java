/*
BAEKJOON
이분 탐색
2805번_나무 자르기
Code_By_Goun
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	// needLen: 필요 길이, heights: 나무길이배열
	public static int findHeight(int needLen, int[] heights) {
		int len = heights.length;
		int left = 0, right = heights[len - 1];
		int mid = 0;
		
		while(left <= right) {	
			mid = (left + right) / 2;
			long sum = 0;
			
			// 합 구하기
			for (int n = 0; n < len; n++) {
				sum += (heights[n] - mid > 0) ? heights[n] - mid: 0;
			}
			
			if (sum >= needLen) {
				left = mid + 1;
			} else if (sum < needLen){
				right = mid - 1;
			}
		}
		return right;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int treeLen = Integer.parseInt(st.nextToken());
		int needLen = Integer.parseInt(st.nextToken());
		
		int[] heights = new int[treeLen];
		int avg = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < treeLen; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
			avg += heights[i];
		}
		Arrays.sort(heights);
		avg = (int) Math.floor(avg / treeLen);
		
		bw.write(findHeight(needLen, heights) + "");
		bw.flush();
		bw.close();
	}
}
