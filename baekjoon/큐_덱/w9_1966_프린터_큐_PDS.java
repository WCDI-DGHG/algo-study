import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputLen = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputLen; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
            Deque<Integer> dq = new ArrayDeque<>();
            Deque<Integer> indexDq = new ArrayDeque<>();
            int index = inputToIntArr(br.readLine())[1];
            int count = 1;
            int[] arr2 = inputToIntArr(br.readLine());
            dq.addAll(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
            pq.addAll(dq);
            for (int j = 0; j < dq.size(); j++) {
                indexDq.add(j);
            }
            while (!pq.isEmpty()) {
                if (pq.peek() == dq.peekFirst() && index == indexDq.peekFirst()) {
                    System.out.println(count);
                    break;
                }

                if (pq.peek() == dq.peekFirst()) {
                    pq.poll();
                    count++;
                }
                dq.addLast(dq.pollFirst());
                indexDq.addLast(indexDq.pollFirst());
            }
        }
    }

    private static int[] inputToIntArr(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(val -> Integer.parseInt(val)).toArray();
    }
}