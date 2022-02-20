import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxBound = Integer.parseInt(br.readLine().split(" ")[1]);
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = -1;
        // 더 좋은 방법이 없을까
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                temp += array[j];
                for (int k = j + 1; k < array.length; k++) {
                    temp += array[k];
                    if (temp <= maxBound && temp > sum) {
                        sum = temp;
                    }
                    temp -= array[k];
                }
                temp -= array[j];
            }
        }
        System.out.println(sum);
    }
}