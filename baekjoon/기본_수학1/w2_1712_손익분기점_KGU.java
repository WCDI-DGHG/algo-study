/*
BAEKJOON
1712번_손익분기점
Code_By_Goun
*/

import java.io.*;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		
		long fixPriceA = Long.parseLong(st.nextToken());
		int expenseB = Integer.parseInt(st.nextToken());
		int priceC = Integer.parseInt(st.nextToken());
		long income = 0;
		long totalPrice = fixPriceA + expenseB;
		
		if(priceC <= expenseB) {
			bw.write("-1");
		} else {
			// 증감 범위 조절용
			long productNum = fixPriceA / (priceC - expenseB);
			
			while (income <= 0) {
				totalPrice = fixPriceA + ++productNum;
				income = (productNum * priceC) - totalPrice;
			}
			
			bw.write(productNum + "");
		}

		bw.flush();
		bw.close();
	}
}

