import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[] xMove = {0, 0, -1, 1};
    private static int[] yMove = {1, -1, 0, 0};
    private static int[][] check;
    private static Queue<int[]> queue = new LinkedList<>();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] lenArray = strToIntArray(br.readLine());

        int yLen = lenArray[0];
        int xLen = lenArray[1];
        int[][] board = new int[xLen][yLen];
        check = new int[xLen][yLen];

        for (int i = 0; i < xLen; i++) {
            board[i] = strToIntArray(br.readLine());
        }

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 1) {
                    count++;
                    queue.add(new int[]{i, j});
                }
                if (board[i][j] == -1) {
                    count++;
                }
            }
        }
        bfs(board);
        if (count != xLen * yLen) {
            System.out.println(-1);
            return;
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                answer = Math.max(answer, check[i][j]);
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int[][] board) {
        while (!queue.isEmpty()) {
            int[] currentXY = queue.poll();
            for (int i = 0; i < xMove.length; i++) {
                int nextX = currentXY[0] + xMove[i];
                int nextY = currentXY[1] + yMove[i];
                if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && board[nextX][nextY] == 0) {
                    if (board[nextX][nextY] != 1) {
                        board[nextX][nextY] = 1;
                        count++;
                    }
                    queue.offer(new int[]{nextX, nextY});
                    check[nextX][nextY] = check[currentXY[0]][currentXY[1]] + 1;
                }
            }
        }
    }

    private static int[] strToIntArray(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
