import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        System.out.println(facto(inputNumber));
    }

    private static int facto(int number) {
        if (number <= 1) {
            return Math.max(number, 1);
        }
        return number * facto(--number);
    }
}
