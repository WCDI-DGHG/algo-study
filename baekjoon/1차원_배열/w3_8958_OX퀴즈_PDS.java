import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 입력받을 문자열 길이 최대치가 얼마 안되니까 미리 선언해서 만들어버리기
    private static int[] arr = new int[81];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // O 길이에 따른 점수
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + i;
        }

        int len = Integer.parseInt(br.readLine());

        for (int i = 0; i < len; i++) {
            String[] splitArr = br.readLine().split("X", -1);
            int tempSum = 0;
            for (int j = 0; j < splitArr.length; j++) {
                tempSum += arr[splitArr[j].length()];
            }
            System.out.println(tempSum);
        }
        
        // 같은 코드
//        for (int i = 0; i < len; i++) {
//            System.out.println(
//                    Arrays.stream(br.readLine().split("X", -1))
//                            .map(v -> arr[v.length()])
//                            .collect(Collectors.toList())
//                            .stream()
//                            .mapToInt(n -> n).sum());
//        }
    }
}
