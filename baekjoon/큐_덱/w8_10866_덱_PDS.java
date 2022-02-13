import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputLen = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inputLen; i++) {
            String input = br.readLine();
            if (input.contains("push_front")) {
                deque.offerFirst(Integer.parseInt(input.split(" ")[1]));
                continue;
            }
            if (input.contains("push_back")) {
                deque.offerLast(Integer.parseInt(input.split(" ")[1]));
                continue;
            }
            switch (input) {
                case "pop_front":
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
                    break;
                case "pop_back":
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast());
                    break;
                case "size":
                    sb.append(deque.size());
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast());
                    break;
                default:
                    break;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
