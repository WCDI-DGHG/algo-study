import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextInt() * sc.nextInt() * sc.nextInt() + "";
        int[] arr = new int[10];
        input.chars().forEach(v -> ++arr[v-48]);
        Arrays.stream(arr).forEach(Main::print);
    }
    static void print(int n) {
        System.out.println(n);
    }
}