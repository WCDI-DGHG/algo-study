import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len + 3];
        int prev = 0;
        for (int i = 3; i < len + 3; i++) {
            int current = sc.nextInt();
            array[i] = current + Math.max(prev + array[i - 3], array[i - 2]);
            prev = current;
        }
        System.out.println(array[len + 2]);
    }
}