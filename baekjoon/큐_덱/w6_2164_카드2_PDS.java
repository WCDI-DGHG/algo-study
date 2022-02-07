import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < number + 1; i++) {
            deque.addLast(i);
        }
        while (deque.size() != 1) {
            deque.removeFirst();
            deque.addLast(deque.removeFirst());
        }
        System.out.println(deque.peek());
    }
}