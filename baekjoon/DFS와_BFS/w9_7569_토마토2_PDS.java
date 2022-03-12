import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[] xMove = {0, 0, -1, 1};
    private static int[] yMove = {1, -1, 0, 0};
    private static int[][][] check;
    private static Queue<int[]> queue = new LinkedList<>();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] lenArray = strToIntArray(br.readLine());

        int yLen = lenArray[0];
        int xLen = lenArray[1];
        int zLen = lenArray[2];
        int[][][] board = new int[zLen][xLen][yLen];

        check = new int[zLen][xLen][yLen];

        for (int i = 0; i < zLen; i++) {
            for (int j = 0; j < xLen; j++) {
                board[i][j] = strToIntArray(br.readLine());
            }
        }


        for (int k = 0; k < zLen; k++) {
            for (int i = 0; i < xLen; i++) {
                for (int j = 0; j < yLen; j++) {
                    if (board[k][i][j] == 1) {
                        count++;
                        // z x y
                        queue.add(new int[]{k, i, j});
                    }
                    if (board[k][i][j] == -1) {
                        count++;
                    }
                }
            }
        }
        bfs(board);
        if (count != zLen * xLen * yLen) {
            System.out.println(-1);
            return;
        }
        int answer = Integer.MIN_VALUE;
        for (int k = 0; k < zLen; k++) {
            for (int i = 0; i < xLen; i++) {
                for (int j = 0; j < yLen; j++) {
                    answer = Math.max(answer, check[k][i][j]);
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int[][][] board) {
        while (!queue.isEmpty()) {
            int[] currentZXY = queue.poll();
            int currentX = currentZXY[1];
            int currentY = currentZXY[2];
            int currentZ = currentZXY[0];
            // up
            if (currentZ + 1 < board.length) {
                if (board[currentZ + 1][currentX][currentY] == 0) {
                    board[currentZ + 1][currentX][currentY] = 1;
                    count++;
                    queue.offer(new int[]{currentZ + 1, currentX, currentY});
                    check[currentZ + 1][currentX][currentY] = check[currentZ][currentX][currentY] + 1;
                }
            }
            // down
            if (currentZ - 1 >= 0) {
                if (board[currentZ - 1][currentX][currentY] == 0) {
                    board[currentZ - 1][currentX][currentY] = 1;
                    count++;
                    queue.offer(new int[]{currentZ - 1, currentX, currentY});
                    check[currentZ - 1][currentX][currentY] = check[currentZ][currentX][currentY] + 1;
                }
            }
            for (int i = 0; i < xMove.length; i++) {
                int nextX = currentX + xMove[i];
                int nextY = currentY + yMove[i];
                if (nextX >= 0 && nextX < board[0].length && nextY >= 0 && nextY < board[0][0].length && board[currentZ][nextX][nextY] == 0) {
                    board[currentZ][nextX][nextY] = 1;
                    count++;
                    queue.offer(new int[]{currentZ, nextX, nextY});
                    check[currentZ][nextX][nextY] = check[currentZ][currentX][currentY] + 1;
                }
            }
        }
    }


    private static int[] strToIntArray(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}