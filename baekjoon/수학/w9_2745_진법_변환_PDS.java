import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        System.out.println(toBJinBub(inputArr[0],Integer.parseInt(inputArr[1])));
    }

    private static int toBJinBub(String str, int jinBub) {
        AtomicInteger atomicInteger = new AtomicInteger();
        return str.chars()
                .map(value ->
                        (int) Math.pow(jinBub, (str.length() - 1) - atomicInteger.getAndIncrement()) * ((value > 64) ? (value - 55) : value - 48)).sum();
    }
}