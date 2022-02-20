import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Deque<Character> deque = new ArrayDeque<>();
            String input = br.readLine();
            if (".".equals(input)) {
                break;
            }
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (currentChar == '[' || currentChar == '(') {
                    deque.offerLast(currentChar);
                    continue;
                }
                if (currentChar == ']') {
                    if (deque.isEmpty() || deque.peekLast() != '[') {
                        deque.offerLast(currentChar);
                        break;
                    }
                    deque.pollLast();
                    continue;
                }
                if (currentChar == ')') {
                    if (deque.isEmpty() || deque.peekLast() != '(') {
                        deque.offerLast(currentChar);
                        break;
                    }
                    deque.pollLast();
                }
            }
            if (deque.isEmpty()) {
                sb.append("yes").append("\n");
            }else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}