import java.util.Arrays;

class Solution {
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int[] disArray = new int[rocks.length + 1];
        disArray[0] = rocks[0];
        disArray[disArray.length - 1] = distance - rocks[rocks.length - 1];
        for (int i = 1; i < rocks.length; i++) {
            disArray[i] = rocks[i] - rocks[i - 1];
        }

        return search(disArray, distance, n);
    }

    private static int search(int[] disArray, int distance, int n) {
        int answer = 0;
        long left = 0;
        long right = distance;
        while (left <= right) {
            long mid = (left + right) / 2;
            int removed = 0;
            int current = 0;
            for (int i = 0; i < disArray.length; i++) {
                if (current + disArray[i] < mid) {
                    current += disArray[i];
                    removed++;
                } else {
                    current = 0;
                }
                if (removed > n) {
                    break;
                }
            }
            if (removed <= n) {
                left = mid + 1;
                if (answer < mid) {
                    answer = (int) mid;
                }
                continue;
            }
            right = mid - 1;
        }
        return answer;
    }
}
