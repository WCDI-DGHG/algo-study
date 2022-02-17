/*
BAEKJOON
DFS와 BFS
1260번_DFS와 BFS
Code_By_Goun
*/
/*
풀이 참고
    1  2  3  4		    1  2  3  4  5
1  0  1  1  1		1  0  1  1  0  0
2  1  0  0  1		2  1  0  0  0  1
3  1  0  0  1		3  1  0  0  1  0
4  1  1  1  0		4  0  0  1  0  1
			5  0  1  0  1  0
*/

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int node, line, start;
	static int[][] nodeArr;
	static Boolean[] visited;
	
	public static String DFS() {
		StringBuffer sb = new StringBuffer();
		
		// offerLast(), pollLast(), peekLast()
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int now = stack.pollLast();
			if(visited[now]) continue;
			visited[now] = true;
			
			for(int i = node; i >= 1; i--) {
				if(nodeArr[now][i] == 1 && visited[i] == false) {
					stack.offerLast(i);
				}
			}

			sb.append(now + " ");
		}
		
		return sb.toString();
	}
	
	public static String BFS() {
		StringBuffer sb = new StringBuffer();
		
		// offer(), poll(), peek() 
		Deque<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;

		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i = 1; i <= node; i++) {
				if (nodeArr[now][i] == 1 && visited[i] == false) {
					queue.offer(i);
					visited[i] = true;
				}
			}

			sb.append(now + " ");
		}
		
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		nodeArr = new int[node + 1][node + 1];
		visited =  new Boolean[node + 1];
		
		for (int i = 1; i <= line; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			nodeArr[node1][node2] = 1;
			nodeArr[node2][node1] = 1;
		}

		Arrays.fill(visited, false);
		bw.write(DFS());
		bw.write("\n");
		Arrays.fill(visited, false);
		bw.write(BFS());
		
		bw.flush();
		bw.close();
	}

}
