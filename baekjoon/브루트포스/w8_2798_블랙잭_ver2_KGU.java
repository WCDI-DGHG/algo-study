/*
BAEKJOON
브루트포스(완전탐색)
2798번_블랙잭
Code_By_Goun
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int add(int M, int numOfCard, int[] cards) {
		int sum = 0, max = 0;
//		int count=0;	// 총 횟수 세기용
		
		for (int a = 0; a < numOfCard - 2; a++) {
			for (int b = a + 1; b < numOfCard - 1; b++) {
				if(cards[a] + cards[b] + cards[b+1] > M) {
//					System.out.println("총 횟수:" + ++count);
					break;
				}
				
				for (int c = b + 1; c < numOfCard; c++) {
					sum = cards[a] + cards[b] + cards[c];
//					count++;

					if (sum > M) {
						break;
					} else if (max < sum) {
						max = sum;
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		st = new StringTokenizer(str1);
		int numOfCard = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(str2);
		int[] cards = new int[numOfCard];
		for (int i = 0; i < numOfCard; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);

		bw.write(add(M, numOfCard, cards)+"");
		bw.flush();
		bw.close();

	}

}
