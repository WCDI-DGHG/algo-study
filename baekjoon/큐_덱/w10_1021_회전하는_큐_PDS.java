import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        int answer = 0;

        for (int i = 0; i < M; i++) {

            int currentNumber = ((LinkedList<Integer>) deque).indexOf(sc.nextInt());
            int midNumber = (int) (Math.floor((double) deque.size() / 2 - 0.1));

            if (currentNumber <= midNumber) {
                answer += dequePollFirst(deque, currentNumber);
            } else {
                answer += dequePollLast(deque, deque.size() - currentNumber);
            }
            deque.pollFirst();
        }
        System.out.println(answer);
    }

    private static int dequePollFirst(Deque<Integer> deque, int bound) {
        int count = 0;
        for (int i = 0; i < bound; i++) {
            deque.offerLast(deque.pollFirst());
            count++;
        }
        return count;
    }

    private static int dequePollLast(Deque<Integer> deque, int bound) {
        int count = 0;
        for (int i = 0; i < bound; i++) {
            deque.offerFirst(deque.pollLast());
            count++;
        }
        return count;
    }
}