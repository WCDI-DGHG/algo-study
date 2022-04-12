import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] simSaDae = new int[inputArr[0]];
        int friendsNum = inputArr[1];

        for (int i = 0; i < inputArr[0]; i++) {
            simSaDae[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(simSaDae);
        System.out.println(search(simSaDae, friendsNum));
    }

    private static long search(int[] simSaArray, int friendsNum) {
        long left = 0;
        long right = (long) simSaArray[0] * friendsNum;
        long result = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sumOfFriends = Arrays.stream(simSaArray).mapToLong(value -> (mid / value)).sum();

            if (sumOfFriends >= friendsNum) {
                right = mid - 1;
                result = Math.min(result, mid);
                continue;
            }
            left = mid + 1;
        }
        return result;
    }
}
