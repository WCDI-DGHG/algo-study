/*
BAEKJOON
10870번_피보나치 수5
Code_By_Goun
*/
/*
알고리즘 설명(?)
0	= 0
1	= 1
2	= 1 + 0		= 1
3	= 1 + 1		= 2
4	= 2 + 1		= 3
5	= 3 + 2		= 5
...
*/

import java.io.*;

public class Main {
	
	public static int fibonach(int num) {
		int sum = 0;
		
		if(num == 0) {
			sum = 0;
		} else if (num == 1){
			sum = 1;
		} else {
			sum = fibonach(num - 1) + fibonach(num -2);
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		bw.write(fibonach(num)+"");
		
		bw.flush();
		bw.close();

	}

}
