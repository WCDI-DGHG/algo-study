import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Character, Long> map = new HashMap<>();
    private static final int PRIME = 1234567891;

    public static void main(String[] args) throws IOException {
        setWordMap();
        int a = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputLen = Integer.parseInt(br.readLine());
        String word = br.readLine();

        long sum = 0;

        for (int i = 0; i < inputLen; i++) {
            char currentChar = word.charAt(i);
            sum = sum + map.get(currentChar) * myPow(31, a++);
            sum %= PRIME;
        }
        System.out.println(sum);
    }

    private static void setWordMap() {
        int i = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, (long) i++);
        }
    }

    private static long myPow(long num, int power) {
        long result = 1;
        for (int i = 0; i < power; i++) {
            result = result * num % PRIME;
        }
        return result;
    }
}
