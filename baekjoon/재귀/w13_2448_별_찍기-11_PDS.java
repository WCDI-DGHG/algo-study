import java.util.Scanner;

public class Main {

    private static String[][] TRI = new String[3][5];
    private static String[][] array = null;

    public static void main(String[] args) {
        setTri();

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        array = new String[number][number * 2];

        zaeGui(0, 0, number / 3);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number * 2; j++) {
                sb.append("*".equals(array[i][j]) ? "*" : " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void zaeGui(int X, int Y, int startIndex) {
        if (startIndex <= 1) {
            drawTri(X, Y);
            return;
        }
        // 위 중간
        zaeGui(X + 3 * startIndex / 2, Y, startIndex / 2);
        // 밑 왼쪽
        zaeGui(X, Y + 3 * startIndex / 2, startIndex / 2);
        // 밑 오른쪽
        zaeGui(X + 3 * startIndex, Y + 3 * startIndex / 2, startIndex / 2);
    }

    private static void drawTri(int X, int Y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                array[i + Y][j + X] = TRI[i][j];
            }
        }
    }

    private static void setTri() {
        TRI[0] = "  *  ".split("");
        TRI[1] = " * * ".split("");
        TRI[2] = "*****".split("");
    }

}