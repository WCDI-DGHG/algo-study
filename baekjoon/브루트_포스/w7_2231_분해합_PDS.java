import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int i = 1;
        while (true) {
            int currentSaintSungJar = saintSungJar(i);
            if (currentSaintSungJar == input) {
                System.out.println(i);
                return;
            }
            if (i == input) {
                System.out.println(0);
                return;
            }
            i++;
        }
    }

    private static int saintSungJar(int input) {
        return input + (input + "").chars().map(c -> c - 48).sum();
    }
}