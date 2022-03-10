/*
BAEKJOON
12015번_가장 긴 증가하는 부분 수열2
Code_By_Goun
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> list = new ArrayList<>();
	
	public static int makeSeq(int value, int end) {
		int left = 0, right = end;
		int mid = 0;
		
		while (left < right) {
			mid = (left + right) / 2;
			
			if (value <= list.get(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		list.add(0);	// 비교용 최솟값(수열의 최솟값은 1이므로 1보다 작은 0을 넣어줌)

		for (int i = 0 ; i < count; i++) {
			int value = Integer.parseInt(st.nextToken());
			int end = list.size() - 1;
			
			if (value > list.get(end)) {
				list.add(value);
			} else {
				list.set(makeSeq(value, end), value);
			}
		}
		System.out.println(list.size() - 1);
	}
}