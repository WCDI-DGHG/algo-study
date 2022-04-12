import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int[] resultArray = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = scanner.nextInt();
        resultArray = new int[caseNumber];
        Arrays.fill(resultArray, Integer.MAX_VALUE);

        for (int i = 0; i < caseNumber; i++) {
            int myScore = scanner.nextInt();
            int yourScore = scanner.nextInt();
            dfs(myScore, yourScore, 0, i);
        }

        Arrays.stream(resultArray).forEach(v -> System.out.println(v));

    }

    private static void dfs(int myScore, int yourScore, int currentCount, int idx) {
        if (myScore > yourScore) {
            return;
        }

        if (myScore == yourScore) {
            resultArray[idx] = Math.min(resultArray[idx], currentCount);
            return;
        }

        dfs(myScore * 2, yourScore + 3, currentCount + 1, idx);
        dfs(myScore + 1, yourScore, currentCount + 1, idx);
    }

}