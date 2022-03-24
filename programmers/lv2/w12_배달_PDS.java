import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int N = 5;
        int K = 3;
        System.out.println(solution(N, road, K));
    }

    private static int[] distance;

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Node>[] list = new ArrayList[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, 500001);
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < road.length; i++) {
            int[] array = road[i];
            list[array[0]].add(new Node(array[1], array[2]));
            list[array[1]].add(new Node(array[0], array[2]));
        }
        distance[1] = 0;
        bfs(list, visited);
        return Arrays.stream(distance).filter(v -> v <= K).toArray().length;
    }

    private static void bfs(List<Node>[] list, boolean[] visited) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.getDistance() - o2.getDistance());
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (visited[currentNode.getEnd()]) {
                continue;
            }
            visited[currentNode.getEnd()] = true;
            Iterator<Node> iterator = list[currentNode.getEnd()].listIterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();
                distance[node.getEnd()] = Math.min(distance[node.getEnd()], distance[currentNode.getEnd()] + node.getDistance());
                queue.add(new Node(node.getEnd(), distance[node.getEnd()]));
            }
        }
    }
}

class Node {
    private int end;
    private int distance;

    public Node(int end, int distance) {
        this.end = end;
        this.distance = distance;
    }

    public int getEnd() {
        return end;
    }

    public int getDistance() {
        return distance;
    }
}
