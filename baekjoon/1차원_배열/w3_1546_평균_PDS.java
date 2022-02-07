import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        double[] arr = new double[input];
        for (int i = 0; i < input; i++) {
            arr[i] = scanner.nextInt();
        }
	// 입력받은 배열에서 최대값을 찾는다.
        double max = Arrays.stream(arr).max().getAsDouble();
        System.out.println(
                Arrays.stream(arr)
		// 배열의 모든 값에 최대값을 활용해 공식을 적용한다.
                        .map(v -> (v / max * 100))
                        .average().getAsDouble() // 적용한 모든 값들의 평균을 구한다.
        ); // 출력한다.
    }
}