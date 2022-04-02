import java.util.Arrays;

class Solution {
    public static int solution(int[][] triangle) {

        for (int i = 1; i < triangle.length; i++) {
            int width = triangle[i].length;
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                    continue;
                }
                if (j == width - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                    continue;
                }
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }
}