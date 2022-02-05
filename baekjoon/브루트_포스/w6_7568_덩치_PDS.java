import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        // 덩치 배열
        int[][] massArr = new int[length][2];

        // 값 저장
        for (int i = 0; i < length; i++) {
            String[] inputArr = br.readLine().split(" ");
            massArr[i][0] = Integer.parseInt(inputArr[0]);
            massArr[i][1] = Integer.parseInt(inputArr[1]);
        }

        int[] rankArr = new int[length];
        Arrays.fill(rankArr, 1);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                if (massArr[i][0] < massArr[j][0] && massArr[i][1] < massArr[j][1]) {
                    rankArr[i]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(rankArr).forEach(value -> sb.append(value).append(" "));
        System.out.println(sb.toString());
    }
}