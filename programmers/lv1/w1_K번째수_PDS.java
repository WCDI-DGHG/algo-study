import java.util.Arrays;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(v -> Arrays.stream(
                        Arrays.copyOfRange(array, v[0] - 1, v[1]))
                        .sorted()
                        .toArray()[v[2] - 1])
                .toArray();
    }
}