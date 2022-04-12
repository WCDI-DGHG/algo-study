import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edge));
    }

    private static LinkedList<Integer>[] vertexArray = null;

    public static int solution(int n, int[][] edge) {

        // 방문여부를 체크한다
        boolean[] visited = new boolean[n];

        // 시작지점으로부터의 깊이(거리)를 저장한다
        int[] distanceArray = new int[n];

        // 링크드리스트 초기화
        initList(n);
        // 링크드 리스트에 주어진 노드를 넣는다
        insertEdge(edge);

        // bfs 돌린다
        bfs(0, visited, distanceArray);

        // 거리의 최대값의 개수를 리턴한다.
        return (int) Arrays.stream(distanceArray)
                .filter(value -> value == Arrays.stream(distanceArray)
                        .max()
                        .getAsInt())
                .count();
    }

    private static void bfs(int start, boolean[] visited, int[] distanceArray) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            Iterator<Integer> iterator = vertexArray[currentIndex].listIterator();

            while (iterator.hasNext()) {
                int adj = iterator.next();

                if (!visited[adj]) {
                    visited[adj] = true;
                    distanceArray[adj] = distanceArray[currentIndex] + 1;
                    queue.add(adj);
                }
            }

        }
    }

    private static void initList(int n) {
        vertexArray = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            vertexArray[i] = new LinkedList<>();
        }
    }

    private static void insertEdge(int[][] edge) {
        for (int i = 0; i < edge.length; i++) {
            vertexArray[edge[i][0] - 1].add(edge[i][1] - 1);
            vertexArray[edge[i][1] - 1].add(edge[i][0] - 1);
        }
    }
}
