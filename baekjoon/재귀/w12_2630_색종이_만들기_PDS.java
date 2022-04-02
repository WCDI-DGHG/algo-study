import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int zeroCount = 0;
    private static int oneCount = 0;
    private static int len;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        map = new int[len][len];
        for (int i = 0; i < len; i++) {
            map[i] = strToIntArr(br.readLine());
        }
        zaeGui(map, len);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    private static int[] strToIntArr(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void zaeGui(int[][] array, int len) {

        if (sumOfValIs(0, array)) {
            zeroCount++;
            return;
        }
        if (sumOfValIs(len * len, array)) {
            oneCount++;
            return;
        }

        zaeGui(divideArray(array, 0, len / 2, 0, len / 2, len / 2), len / 2);
        zaeGui(divideArray(array, len / 2, len, 0, len / 2, len / 2), len / 2);
        zaeGui(divideArray(array, 0, len / 2, len / 2, len, len / 2), len / 2);
        zaeGui(divideArray(array, len / 2, len, len / 2, len, len / 2), len / 2);

    }

    private static boolean sumOfValIs(int n, int[][] array) {
        return Arrays.stream(array).flatMap(v -> Arrays.stream(v).boxed()).mapToInt(v -> v).sum() == n;
    }

    private static int[][] divideArray(int[][] array, int xStart, int xEnd, int yStart, int yEnd, int len) {

        int[][] resultArray = new int[len][len];
        for (int i = xStart; i < xEnd; i++) {
            for (int j = yStart; j < yEnd; j++) {
                resultArray[i - xStart][j - yStart] = array[i][j];
            }
        }
        return resultArray;
    }
}