import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 숫자카드2 이분탐색으로 풀기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count1 = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] have = new int[count1];
        for (int i = 0; i < count1; i++) {
            have[i] = Integer.parseInt(st1.nextToken());
        }

        int count2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] correct = new int[count2];
        for (int i = 0; i < count2; i++) {
            correct[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(have);
        int[] result = new int[count2];

        for (int i = 0; i < count2; i++) {
            int currentValue = correct[i];
            int countOfCurrentValue = getMinIndexGreaterThanCurrentValue(currentValue, have) - getMaxIndexLessThanCurrentValue(currentValue, have);
            result[i] += countOfCurrentValue;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int getMaxIndexLessThanCurrentValue(int curVal, int[] arr) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (curVal <= arr[mid]) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }

        return left;
    }

    public static int getMinIndexGreaterThanCurrentValue(int curVal, int[] arr) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (curVal < arr[mid]) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }
}