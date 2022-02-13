import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                arr[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            arr[st.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}