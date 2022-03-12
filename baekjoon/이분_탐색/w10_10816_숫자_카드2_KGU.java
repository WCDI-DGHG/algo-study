/*
BAEKJOON
10816번_숫자 카드 2
Code_By_Goun
오류 해결된 코드
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static Map<Integer, Integer> makeMap(String str) {
		StringTokenizer st = new StringTokenizer(str);
		Map<Integer, Integer> map = new HashMap<>();
		
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			map.computeIfPresent(num, (key, value) -> value + 1);
			map.putIfAbsent(num, 1);
		}
		return map;
	}
	
	static int[] makeArr(int count, String str) {
		StringTokenizer st = new StringTokenizer(str);
		int[] arr = new int[count];
		
		for (int i = 0; i < count; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		return arr;
	}
	
	static boolean countNum(int target, Object[] sArr) {
		int left = 0, right = sArr.length - 1;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			//System.out.println(left + "\t" + mid + "\t" + right);
			
			if ((int) sArr[mid] > target) {
				right = mid - 1;
			} else if ((int) sArr[mid] < target) {
				left = mid + 1;
			} else {
				return true;
			}//end if-else

		}//end while
		//System.out.println("END");
		return false;
	}//end countNum()

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 입력받기
		int sCount = Integer.parseInt(br.readLine());
		Map<Integer, Integer> sMap = makeMap(br.readLine());
		int nCount = Integer.parseInt(br.readLine());
		int[] nArr = makeArr(nCount, br.readLine());
		Object[] sArr = sMap.keySet().toArray();
		Arrays.sort(sArr);
		
		for(int i = 0; i < nCount; i++) {
			if(countNum(nArr[i], sArr)) {
				sb.append(sMap.get(nArr[i])+ " ");
			} else {
				sb.append("0 ");
			}
		}
		bw.write(sb+"");
		bw.flush();
		bw.close();
	}

}