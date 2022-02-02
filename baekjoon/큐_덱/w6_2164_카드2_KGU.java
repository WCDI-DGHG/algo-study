/*
BAEKJOON
2164번_카드2
Code_By_Goun
*/
/*
사용 알고리즘
	위		아래		  위		아래
	1    2    3    4    5    6	-poll()->     2    3    4    5    6	-offer(poll())->	3    4    5    6    2

-poll()->	      4    5    6    2  	-offer(poll())->	5    6    2    4	-poll()->	      	6    2    4  	

-offer(poll())->	2    4    6	-poll()->	          4    6    	  	-offer(poll())->	6    4 

-poll()->	      4 
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<>();
		
		int count = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= count; i++) {
			queue.offer(i);
		}
		
		int cnt = 1;
		while(queue.size() > 1) {
			if (cnt % 2 == 1) {
				queue.poll();
			} else {
				queue.offer(queue.poll());
			}
			cnt++;
		}
		
		bw.write(queue.peek()+"");
		bw.flush();
		bw.close();
		
	}

}
