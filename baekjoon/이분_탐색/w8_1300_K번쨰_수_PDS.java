import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arrLen = sc.nextInt();
        int index = sc.nextInt();
        System.out.println(search(index, arrLen));

    }

    private static long search(int index, int arrLen) {
        long left = 0;
        long right = index;
        while (left < right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 1; i <= arrLen; i++) {
                sum += Math.min(mid / i, arrLen);
            }

            if (sum >= index) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }
}