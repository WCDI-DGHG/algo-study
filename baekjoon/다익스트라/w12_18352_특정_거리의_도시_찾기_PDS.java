import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {
    private static int cityNum = 0;
    private static int roadNum = 0;
    private static int distance = 0;
    private static int start = 0;
    private static PriorityQueue<Integer> resultList = new PriorityQueue<>();
    private static int[] distanceArray = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = strToIntArr(br.readLine());
        cityNum = inputArr[0];
        roadNum = inputArr[1];
        distance = inputArr[2];
        start = inputArr[3];

        LinkedList<Integer>[] list = new LinkedList[cityNum + 1];
        distanceArray = new int[cityNum + 1];
        Arrays.fill(distanceArray, 300001);
        initList(list);

        for (int i = 0; i < roadNum; i++) {
            int[] input = strToIntArr(br.readLine());
            list[input[0]].add(input[1]);
        }
        bfs(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distanceArray.length; i++) {
            if (distanceArray[i] == distance) {
                resultList.add(i);
            }
        }
        resultList.forEach(v -> sb.append(v.intValue()).append("\n"));

        if (sb.toString().equals("")) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }
    }

    private static void bfs(LinkedList<Integer>[] list) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distanceArray[start] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            Iterator<Integer> iter = list[current].listIterator();
            while (iter.hasNext()) {
                int adj = iter.next();
                if (distanceArray[current] + 1 < distanceArray[adj]) {
                    distanceArray[adj] = distanceArray[current] + 1;
                    queue.offer(adj);
                }
            }
        }
    }

    private static int[] strToIntArr(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void initList(LinkedList<Integer>[] list) {
        for (int i = 0; i <= cityNum; i++) {
            list[i] = new LinkedList<>();
        }
    }
}