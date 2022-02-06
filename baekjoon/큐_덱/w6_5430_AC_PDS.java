import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int orderNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < orderNum; i++) {
            String order = br.readLine();
            br.readLine();
            String inputedNumber = br.readLine();

            if (getError(inputedNumber) && order.contains("D")) {
                sb.append("error").append("\n");
                continue;
            }
            Deque<String> deque =
                    getStringToIntegerDeque(inputedNumber.replace("[", "").replace("]", ""));

            boolean reversed;
            try {
                reversed = doOrder(deque, order);
            } catch (CanNotExecuteOrderException e) {
                sb.append(e.getMessage()).append("\n");
                continue;
            }
            addString(deque, reversed);
        }
        System.out.println(sb.toString());
    }

    private static Deque<String> getStringToIntegerDeque(String order) {
        return new ArrayDeque<>(Arrays.stream(order.split(",")).
                collect(Collectors.toCollection(ArrayDeque::new)));
    }

    private static boolean doOrder(Deque<String> deque, String order) throws CanNotExecuteOrderException {
        // false : asc , true : desc
        boolean reversed = false;
        for (int i = 0; i < order.length(); i++) {
            if ('R' == order.charAt(i)) {
                reversed = doR(reversed);
                continue;
            }
            doD(deque, reversed);
        }
        return reversed;
    }

    private static String doD(Deque<String> deque, boolean reversed) throws CanNotExecuteOrderException {
        getError(deque);
        if (reversed) {
            return deque.pollLast();
        }
        return deque.pollFirst();
    }

    private static boolean doR(boolean reversed) {
        return !reversed;
    }

    private static void addString(Deque<String> deque, boolean reversed) {
        sb.append("[");
        while (!deque.isEmpty()) {
            if (deque.size() == 1) {
                sb.append(deque.poll());
                continue;
            }
            sb.append(doD(deque, reversed)).append(",");
        }
        sb.append("]").append("\n");
    }

    private static boolean getError(Deque<String> deque) {
        if (deque.isEmpty()) {
            throw new CanNotExecuteOrderException("error");
        }
        return false;
    }

    private static boolean getError(String order) {
        if ("[]".equals(order)) {
            return true;
        }
        return false;
    }
}

class CanNotExecuteOrderException extends IllegalArgumentException {
    public CanNotExecuteOrderException(String message) {
        super(message);
    }
}