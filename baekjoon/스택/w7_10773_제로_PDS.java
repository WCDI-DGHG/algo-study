import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputLen = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < inputLen; i++) {
            int inputNum = sc.nextInt();
            if (inputNum == 0) {
                deque.pollLast();
                continue;
            }
            deque.offerLast(inputNum);
        }
        System.out.println(deque.stream().mapToInt(val -> val).sum());
    }
}