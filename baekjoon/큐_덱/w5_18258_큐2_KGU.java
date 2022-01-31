/*
BAEKJOON
18258번_큐2
Code_By_Goun
*/

package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;


class Queue {
	public static LinkedList<Integer> queue = new LinkedList<Integer>();
	public static int fIndex = -1;
	public static int lIndex = -1;
	
	public static void push(int x) {
		queue.add(++lIndex, x);
		System.out.println(lIndex + "L\t" + queue.toString());
	}
	
	public static int pop() {
		if (empty() == 0) {
			int num = queue.get(++fIndex);
			queue.remove(fIndex);
			System.out.println(fIndex + "F\t" + lIndex + "L\t"+ queue.toString());
			
			return num;
		}
		System.out.println(fIndex + "F\t" + lIndex + "L\t" + queue.toString());
		return -1;
	}
	
	public static int size() {
		return queue.size();
	}
	
	public static int empty() {
		System.out.println(fIndex + "\t" + lIndex);
		if (fIndex == lIndex) {
			return 1;
		}
		return 0;
	}
	
	public static int front() {
		if (empty() == 1) {
			return -1;
		}
		return queue.get(fIndex + 1);
	}
	
	public static int back() {
		if (empty() == 1) {
			return -1;
		}
		return queue.get(lIndex);
	}
}

public class 큐2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push": 
				Queue.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop": 
				bw.write(Queue.pop() + "\n");
				break;
			case "size": 
				bw.write(Queue.size() + "\n");
				break;
			case "empty": 
				bw.write(Queue.empty() + "\n");
				break;
			case "front": 
				bw.write(Queue.front() + "\n");
				break;
			case "back": 
				bw.write(Queue.back() + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}
}