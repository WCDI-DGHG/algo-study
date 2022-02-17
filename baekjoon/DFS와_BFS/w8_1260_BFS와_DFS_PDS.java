import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] optionArr = stringToIntArr(br.readLine());
        int nodeNum = optionArr[0];
        int edgeNum = optionArr[1];
        int start = optionArr[2];

        boolean[][] graph = new boolean[nodeNum][nodeNum];

        for (int i = 0; i < edgeNum; i++) {
            int[] vertex = stringToIntArr(br.readLine());
            graph[vertex[0] - 1][vertex[1] - 1] = true;
            graph[vertex[1] - 1][vertex[0] - 1] = true;
        }

        boolean[] visited = new boolean[nodeNum];
        dfs(start - 1, graph, visited);
        sb.append("\n");
        visited = new boolean[nodeNum];
        bfs(start - 1, graph, visited);

        System.out.println(sb.toString());
    }

    private static void dfs(int start, boolean[][] graph, boolean[] visited) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        sb.append(start + 1).append(" ");
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] && !visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }

    private static void bfs(int start, boolean[][] graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (visited[current]) {
                continue;
            }
            sb.append(current + 1).append(" ");
            visited[current] = true;
            for (int i = 0; i < graph.length; i++) {
                if (graph[current][i] && !visited[i]) {
                    queue.add(i);
                }
            }
        }
    }

    private static int[] stringToIntArr(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
    }
}