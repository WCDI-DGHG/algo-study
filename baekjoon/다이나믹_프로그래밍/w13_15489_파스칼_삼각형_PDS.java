import java.util.Scanner;

public class Main {
    private static int[][] wholeTriangle = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int startIndex = sc.nextInt();
        int end = sc.nextInt();

        int triLen = start + end - 1;
        wholeTriangle = new int[triLen][triLen];

        int rowBound = 1;
        // 삼각형을 만듭니다 주어진 입력에 맞는 크기로
        for (int i = 0; i < triLen; i++) {
            wholeTriangle[i][0] = 1;
            for (int k = 1; k < rowBound; k++) {
                wholeTriangle[i][k] = wholeTriangle[i - 1][k - 1] + wholeTriangle[i - 1][k];
            }
            rowBound++;
        }

        rowBound = 1;
        int answer = 0;

        // 주어진 범위의 합을 구합니다
        for (int i = start - 1; i < triLen; i++) {
            for (int j = startIndex - 1; j < rowBound + startIndex - 1; j++) {
                answer += wholeTriangle[i][j];
            }
            rowBound++;
        }
        System.out.println(answer);
    }
}
