import java.util.Scanner;

public class Main {
    private static int len = 0;
    private static int bound = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bound = scanner.nextInt();
        len = scanner.nextInt();
        int[] array = new int[9];
        jaeGui(1, array, 0);
    }

    private static void jaeGui(int number, int[] array, int index) {

        if (index == len) {
            for (int i = 0; i < len; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = number; i <= bound; i++) {
            array[index] = i;
            jaeGui(i + 1, array, index + 1);
        }
    }

}
