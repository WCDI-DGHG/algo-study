import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int[] RANGE_TIME_ARRAY = {300, 60, 10};

    public static void main(String[] args) {
        int time = new Scanner(System.in).nextInt();
        if (!validTime(time)) {
            System.out.println("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RANGE_TIME_ARRAY.length; i++) {
            sb.append(time / RANGE_TIME_ARRAY[i]).append(" ");
            time = time % RANGE_TIME_ARRAY[i];
        }
        System.out.println(sb.toString());
    }

    private static boolean validTime(int time) {
        return time % Arrays.stream(RANGE_TIME_ARRAY).min().getAsInt() == 0;
    }
}