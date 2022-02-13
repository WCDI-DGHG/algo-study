import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int criteria = inputToIntArr(br.readLine())[1];
        int[] woodArr = inputToIntArr(br.readLine());
        System.out.println(searchMinValueGreaterThanIndex(woodArr, criteria));
    }

    private static int[] inputToIntArr(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(val -> Integer.parseInt(val)).toArray();
    }

    /**
     * @param arr    : 모든 나무에 대한 배열
     * @param cutter : 절단기 높이
     * @return : 모든 나무를 절단기로 자르고 난 뒤에 얻은 나무 총량
     */
    private static long sumOfAllTreeByCutter(int[] arr, long cutter) {
        return Arrays.stream(arr).mapToLong(val -> Math.max(val - cutter, 0)).sum();
    }

    /**
     * @param arr   : 모든 나무에 대한 배열
     * @param value : 최소한 가져가야 하는 나무 총량
     * @return : 최대한 나무를 덜 자를 때의 절단기 높이
     */
    private static long searchMinValueGreaterThanIndex(int[] arr, int value) {
        long answer = 0;
        long min = 0;
        long max = Arrays.stream(arr).max().getAsInt();
        while (min < max) {
            long mid = ((min + max) / 2);
            // 현재 절단기 높이로 자른 나무들의 총합이 기준보다 작으면?
            // 현재 기준과 같거나 높은 절단기는 필요 없다
            if (sumOfAllTreeByCutter(arr, mid) < (long)value) {
                max = mid;
                continue;
            }
            min = mid + 1;
            if (mid > answer) {
                answer = mid;
            }
        }
        return answer;
    }
}