import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[][] map = new int[len][len];
        for (int i = 0; i < len; i++) {
            map[i] = stringToIntArr(br.readLine());
        }
        boolean[][] visited = new boolean[len][len];
        dfs(map, visited, 0, 0);

        if (visited[len - 1][len - 1]) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static void dfs(int[][] map, boolean[][] visited, int x, int y) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (y + map[x][y] < map[0].length) {
            dfs(map, visited, x, y + map[x][y]);
        }
        if (x + map[x][y] < map.length) {
            dfs(map, visited, x + map[x][y], y);
        }
    }

    private static int[] stringToIntArr(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}