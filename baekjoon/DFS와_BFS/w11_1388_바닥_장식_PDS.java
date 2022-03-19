import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int count = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] inputArr = stringToIntArr(br.readLine());
		int x = inputArr[0];
		int y = inputArr[1];
		
		String[][] map = new String[x][y];
		
		for(int i = 0 ; i < x; i ++) {
			map[i] = br.readLine().split("");
		}
		boolean visited[][] = new boolean[x][y];
		for(int i = 0; i < x; i ++) {
			for(int j = 0 ; j < y; j ++) {
				if(visited[i][j]) {
					continue;
				}
				dfs(visited,map,i,j,map[i][j]);
				count++;
			}
		}
		System.out.println(count);
		
	}
	private static void dfs(boolean[][] visited, String[][] map, int x, int y, String currentWall ) {
		if(visited[x][y]) {
			return;
		}
		visited[x][y] = true;
		if("-".equals(currentWall) && y + 1 < map[0].length && map[x][y+1].equals(currentWall) ) {
			dfs(visited, map, x, y + 1, currentWall);
		}
		if("|".equals(currentWall) && x + 1 < map.length && map[x+1][y].equals(currentWall) ) {
			dfs(visited, map, x + 1, y, currentWall);
		}
	}

	private static int[] stringToIntArr(String str) {
		return Arrays.stream(str.split(" ")).mapToInt(v->Integer.parseInt(v)).toArray();
	}
}