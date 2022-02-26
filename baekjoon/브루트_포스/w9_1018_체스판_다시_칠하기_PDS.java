import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputLen = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        char[][] board = new char[inputLen[0]][inputLen[1]];
        for (int i = 0; i < board.length; i++) {
            String row = br.readLine();
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int minValue = 65;
        int startY = 0;
        for (int i = 0; i <= board.length - 8; i++) {
            int startX = 0;
            startY++;
            for (int j = 0; j <= board[0].length - 8; j++) {
                startX++;
                minValue = Math.min(minValue, searchBoard(board, 'W', startY - 1, startX - 1));
                minValue = Math.min(minValue, searchBoard(board, 'B', startY - 1, startX - 1));
            }
        }
        System.out.println(minValue);
    }

    private static int searchBoard(char[][] board, char start, int startX, int startY) {
        int count = 0;
        int x = startX;
        int y = startY;
        while (true) {
            if (x == startX + 8) {
                break;
            }
            for (int i = y; i < y + 8; i++) {
                if (board[x][i] != start) {
                    count++;
                }
                start = reverse(start);
            }
            start = reverse(start);
            x++;
        }
        return count;
    }

    private static char reverse(char currentChar) {
        if (currentChar == 'W') {
            return 'B';
        }
        return 'W';
    }
}