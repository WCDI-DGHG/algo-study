/*
BAEKJOON
DFS와 BFS
16173번_점프왕 쩰리(Small)
Code_By_Goun
*/

import java.io.*;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean bfs(int N, int[][] map) {
		Deque<HashMap<Character, Integer>> queue = new LinkedList<>();
		boolean[][] went = new boolean[N][N];
		
		HashMap<Character, Integer> m = new HashMap<>();
		m.put('x', 0);
		m.put('y', 0);
		queue.add(m);
		while (!queue.isEmpty()) {
			HashMap<Character, Integer> temp = queue.poll();
			int x = temp.get('x');
			int y = temp.get('y');
			if(went[x][y]) {
				continue;
			}
			
			int jump = map[x][y];
			if (jump == -1) {
				return true;
			}
			
			went[x][y] = true;
			if (x + jump < N) {
				HashMap<Character, Integer> next = new HashMap<Character, Integer>();
				next.put('x', x + jump);
				next.put('y', y);
				queue.add(next);
			}
			
			if (y + jump < N) {
				HashMap<Character, Integer> next = new HashMap<Character, Integer>();
				next.put('x', x); 
				next.put('y', y + jump);
				queue.add(next);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int x = 0; x < N; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int y = 0; y < N; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean finish = bfs(N, map);
		if (finish) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}

}
