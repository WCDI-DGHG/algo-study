import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < len; i++) {
            search(list, arr[i]);
        }
        System.out.println(list.size() - 1);
    }

    private static void search(List<Integer> list, int number) {
        if (list.get(list.size()-1) < number) {
            list.add(number);
            return;
        }
        int start = 0;
        int end = list.size() - 1;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if ( list.get(mid) >= number) {
                end = mid;
                continue;
            }
            start = mid + 1;
        }
        list.set(end, number);
    }
}
