/*
BAEKJOON
이분 탐색
2805번_나무 자르기_방법1
Code_By_Goun
*/

/* 
알고리즘 풀어보기
정렬
10 15 17 20
기준: 평균값 15.5 = 15
자르면 0  0  2  5 = 7
필요길이: 7
----------------------------
4 26 40 42 46
필요길이 = 20
(기준의 소수점은 내림하여 계산)

기준: 평균값 31.6=31
절단길이: 0 0 9 11 15   = 35
필요길이와 자른 길이 차이 = 15
min = 현재길이차이 = 15

필요 길이에 비해 자른 길이가 크므로 기준에 더해줌
기준: 이전 기준 + 위의 차이값의 반 = 31 + 7 = 38
절단길이: 0 0 2 4 8 = 14
필요 길이와 자른 길이 차이 = 6
기준과 min기준 차이 < 기준과 현재 자른길이 차이
min기준 = 현재 기준 = 14

필요 길이에 비해 현재 자른 길이가 더 작음으로 기준에 빼줌
기준: 이전기준 - 이전 길이 차이 반 = 38 - 3 = 35
절단길이: 0 0 5 7 11 = 23
필요 길이와 자른 길이 차이 = 3
기준과 min기준 차이 < 기준과 현재 자른길이 차이
min기준 = 현재 기준 = 23

필요 길이에 비해 자른 길이가 크므로 기준에 더해줌
기준: 이전기준 + 위의 차이값의 반 = 35 + 1 = 36
절단길이: 0 0 4 6 10 = 20
필요 길이와 자른 길이 차이 0
기준과 min기준 차이 < 기준과 현재 자른길이 차이
min기준 = 현재 기준
*/

/* 시간 초과 발생!!! */
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	// needLen: 필요 길이, standard: 기준(평균값), heights: 나무길이배열
	public static int findHeight(int needLen, int standard, int[] heights) {
		int cutLen;	// cutLen: 자른 길이
		int lenSub = 0; // lenSub: 길이 차이
		int min = 0; // 최소기준(필요 길이와 가장 가까운 기준)
		boolean isEnd = false;
		
		while(!isEnd) {	
			cutLen = 0;
			
			for (int n = 0; n < heights.length; n++) {
				cutLen += (heights[n] - standard > 0) ? heights[n] - standard: 0;
			}
			
			lenSub = Math.abs(needLen - cutLen);
			if (needLen - cutLen < 0) {
				standard = (int) (standard + Math.floor(lenSub / 2));
			} else if (needLen - cutLen > 0) {
				standard = (int) (standard - Math.floor(lenSub / 2));
			} else {
				isEnd = true;
				continue;
			}
			
			// 필요 길이에 더 가까운 절단길이를 min으로 설정
			//if (Math.abs(needLen - min) > Math.abs(needLen - cutLen)) {
			//	min = cutLen;
			//}
			min = Math.min(needLen-min, needLen-cutLen);
		}
		return standard;
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
		
		bw.write(findHeight(needLen, avg, heights) + "");
		bw.flush();
		bw.close();
	}
}