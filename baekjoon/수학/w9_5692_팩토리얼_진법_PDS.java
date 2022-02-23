import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String inputNumber = sc.nextLine();
            if ("0".equals(inputNumber)) {
                break;
            }
            System.out.println(toFactorialInt(inputNumber));
        }
    }

    private static int toFactorialInt(String str) {
        AtomicInteger atomicInteger = new AtomicInteger();
        return str.chars().map(val -> (val - 48) * factorial(str.length() - atomicInteger.getAndIncrement())).sum();
    }

    private static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return factorial(num - 1) * num;
    }
}