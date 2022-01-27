/*
BAEKJOON
10816번_숫자 카드 2
Code_By_Goun
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2 {
	
	public static int countSameNum(int corNum, int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		
		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] == corNum) {
				return mid;
			} else if (nums[mid] < corNum) {
				left = mid + 1;
			} else if (nums[mid] > corNum) {
				right = mid - 1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count1 = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int[] have = new int[count1];
		for (int i = 0; i < count1; i++) {
			have[i] = Integer.parseInt(st1.nextToken());
		}
				
		int count2 = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int[] correct = new int[count2];
		for (int i = 0; i < count2; i++) {
			correct[i] = Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(have);
		
		int[] result = new int[count2];
		Arrays.fill(result, 0);
		for (int i = 0; i < count2; i++) {
			int index = countSameNum(correct[i], have);
			
			int newIndex = index - 1;
			while (newIndex >= 0 || have[newIndex] == correct[i]) {
				result[i]++;
				newIndex--;
			}
			
			newIndex = index + 1;
			while (newIndex < count1 || have[newIndex] == correct[i]) {
				result[i]++;
				newIndex++;
			}
			
		}
		
		bw.write(Arrays.toString(result));

		bw.flush();
		bw.close();
	}

}
