/*
BAEKJOON
4673번_셀프 넘버
Code_By_Goun
*/

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
	
	static int d(int n) {
		int result = n;
		
		while (n != 0) {
			result += n % 10;
			n /= 10;
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<Integer> nums = new HashSet<Integer>();
		Iterator<Integer> iter = null;
		
		int i = 1;
		int result = 0;
		while(i < 10000) {
			result = d(i);
			nums.add(result);
			i++;
		}
		
		iter = nums.iterator();
		i = 1;
		while(iter.hasNext()) {
			int num = iter.next();
			for (; i < num && i < 10000; i++) {
				bw.write(i + "\n");
			}
			i++;
		}
		
		bw.flush();
		bw.close();
	}
}
