import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] inputArr = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            inputArr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        stack.push(count);
        sb.append("+").append("\n");
        int index = 0;
        while (index < len) {
            if (!stack.isEmpty() && stack.peek() == inputArr[index]) {
                stack.pop();
                sb.append("-").append("\n");
                index++;
                continue;
            }
            if (!stack.isEmpty() && inputArr[index] < stack.peek()) {
                stack.push(-1);
                break;
            }

            if (count < len) {
                stack.push(++count);
                sb.append("+").append("\n");
            }
        }
        if (stack.isEmpty()) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}