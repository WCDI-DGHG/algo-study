import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());
        int[][] nodeArray = new int[node][node];
        boolean[] visited = new boolean[node];
        for (int i = 0; i < edgeNum; i++) {
            int[] inputArr =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodeArray[inputArr[0] - 1][inputArr[1] - 1] = 1;
            nodeArray[inputArr[1] - 1][inputArr[0] - 1] = 1;
        }

        System.out.println(bfs(nodeArray, visited, 0));
    }

    private static int bfs(int[][] array, boolean[] visited, int start) {
        int count = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int currentLocation = queue.poll();
            if (visited[currentLocation]) {
                continue;
            }
            visited[currentLocation] = true;
            count++;
            for (int i = 0; i < array.length; i++) {
                if (array[currentLocation][i] == 1 && !visited[i]) {
                    queue.add(i);
                }
            }
        }
        return count;
    }
}