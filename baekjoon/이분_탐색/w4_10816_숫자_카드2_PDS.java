import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        //존재하는 숫자카드의 숫자들을 맵에 저장
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        br.readLine();
        // 주어진 숫자 배열
        int[] resultArr = Arrays.stream(br.readLine().split(" ")).mapToInt(v->Integer.parseInt(v)).toArray();
        StringBuilder sb = new StringBuilder();
        // 주어진 숫자에 대한 숫자 카드를 몇 개 가지고 있나
        Arrays.stream(resultArr).forEach(v -> sb.append(map.getOrDefault(v,0)).append(" "));
        System.out.println(sb.toString());
    }
}
