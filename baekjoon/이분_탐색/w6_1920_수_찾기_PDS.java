import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int[] inputArr = getStringToIntArr(br.readLine());

        br.readLine();
        int[] compareArr = getStringToIntArr(br.readLine());
        Arrays.sort(inputArr);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(compareArr).forEach(val -> sb.append(search(inputArr, val)).append("\n"));
        System.out.println(sb.toString());

        br.close();
    }

    private static int[] getStringToIntArr(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int search(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (value < arr[mid]) {
                right = mid - 1;
                continue;
            }
            if (value > arr[mid]) {
                left = mid + 1;
                continue;
            }
            if (value == arr[mid]) {
                return 1;
            }
        }
        return 0;
    }
}