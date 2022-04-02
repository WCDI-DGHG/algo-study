import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] inputArray = new int[len];

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = sc.nextInt();
        }

        int maxValue = Arrays.stream(inputArray).max().getAsInt();

        int[] answerArray = new int[1001];
        answerArray[0] = 1;
        answerArray[1] = 1;

        for (int i = 2; i < maxValue + 1; i++) {
            answerArray[i] = 1;
            for (int j = 1; j <= i / 2; j++) {
                answerArray[i] += answerArray[j];
            }
        }

        Arrays.stream(inputArray).forEach(value -> System.out.print(answerArray[value] + " "));
    }
}