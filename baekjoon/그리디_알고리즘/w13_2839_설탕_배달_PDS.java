import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sulTangWeight = scanner.nextInt();
        // 5 , 3
        int[] array = {0, 0};

        int adjustedWeight = (sulTangWeight % 5) % 3;
        array[0] = sulTangWeight / 5;
        array[1] = (sulTangWeight % 5) / 3;
        while (adjustedWeight != 0) {
            if (array[0] == 0 && adjustedWeight < 3) {
                System.out.println(-1);
                return;
            }
            adjustedWeight += 5;
            array[0]--;
            array[1] += adjustedWeight / 3;
            adjustedWeight %= 3;
        }

        System.out.println(Arrays.stream(array).sum());
    }
}