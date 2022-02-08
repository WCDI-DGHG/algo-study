import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        int k = sc.nextInt();

        AtomicInteger i = new AtomicInteger(1);
        arr = Arrays.stream(arr).map(val -> i.getAndIncrement()).toArray();

        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while (queue.size() > 1) {
            pollAndOffer(queue, k - 1);
            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append(">");
        System.out.println(sb.toString());
    }

    private static void pollAndOffer(Queue<Integer> queue, int k) {
        while (k > 0) {
            queue.offer(queue.poll());
            k--;
        }
    }
}