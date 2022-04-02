import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int makNum = inputArr[0];
        int peopleNum = inputArr[1];

        int[] makList = new int[makNum];

        for (int i = 0; i < makNum; i++) {
            makList[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(search(makList, peopleNum));
    }

    private static int search(int[] array, int peopleNum) {
        int start = 1;
        int end = Arrays.stream(array).max().getAsInt();
        int answer = 0;
        while (start <= end) {
            int mid = (int) (((long) start + end) / 2);
            if (peopleNum > divideCountByNum(array, mid)) {
                end = mid - 1;
                continue;
            }
            start = mid + 1;
            if (answer < mid) {
                answer = mid;
            }
        }
        return answer;
    }

    private static int divideCountByNum(int[] array, int number) {
        return Arrays.stream(array).map(v -> v / number).sum();
    }
}