import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = stringToIntArr(br.readLine());
        int N = inputArr[0];
        int K = inputArr[1];
        long[] lanArray = new long[N];

        for (int i = 0; i < N; i++) {
            lanArray[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(search(K, lanArray));

    }

    private static int[] stringToIntArr(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int search(int K, long[] array) {
        int left = 1;
        int right = (int) Arrays.stream(array).max().getAsLong();
        int result = -1;
        while (left <= right) {
            int mid = (int) (((long) left + right) / 2);
            if (mid == 0) {
                break;
            }
            if (sumOfDividedNumber(mid, array) >= K) {
                left = mid + 1;
                result = mid;
                continue;
            }
            right = mid - 1;
        }
        return result;
    }

    private static long sumOfDividedNumber(int mid, long[] array) {
        return Arrays.stream(array).map(value -> value / mid).sum();
    }
}