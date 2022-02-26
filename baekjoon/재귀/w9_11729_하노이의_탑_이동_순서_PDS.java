import java.util.Scanner;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputLayer = sc.nextInt();
        sb.append((int) Math.pow(2, inputLayer) - 1).append('\n');
        moveTower(inputLayer, 1, 2, 3);
        System.out.println(sb.toString());
    }

    private static void moveTower(int layer, int A, int B, int C) {
        if (layer == 1) {
            print(A, C);
            return;
        }
        moveTower(layer - 1, A, C, B);
        print(A, C);
        moveTower(layer - 1, B, A, C);
    }

    private static void print(int A, int C) {
        sb.append(A).append(" ").append(C).append("\n");
    }
}