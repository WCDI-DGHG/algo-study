import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int OUgiNum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(v -> Integer.parseInt(v)).toArray();
		int homeNum = inputArr[0];
		OUgiNum = inputArr[1];
		
		int[] array = new int[homeNum];
		
		for(int i = 0;  i < homeNum; i ++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		int result = search(array);
		System.out.println(result);
	}

	private static int search(int[] array) {

		int start = 1;
		int end = array[array.length - 1] - array[0];
		int result = 0;
		while (start <= end) {
			int count = 1;
			int firstHome = array[0];
			int mid = (end + start) / 2;
			for(int i = 1; i < array.length ; i ++) {
				if(array[i] - firstHome >= mid) {
					count++;
					firstHome = array[i];
				}
			}
			// 카운트가 설치해야되는 공유기 수보다 작으면 좁혀야 한다.
			if(count < OUgiNum) {
				end = mid -1;
			}
			else {
				start = mid + 1;
				result = mid;
			}
		}
		return result;
	}
}