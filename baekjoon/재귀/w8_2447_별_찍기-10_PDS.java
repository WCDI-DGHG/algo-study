import java.util.Scanner;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int range = new Scanner(System.in).nextInt();
        runJaeGui(range, 1, 1);
        System.out.println(sb.toString());
    }

    private static void runJaeGui(int range, int x, int y) {
        if (y > range) {
            return;
        }
        printStar(range, x, y);
        // x 좌표가 범위에 도달할 경우 개행해줌
        if (x == range) {
            sb.append("\n");
            runJaeGui(range, 1, y + 1);
        } else {
            runJaeGui(range, x + 1, y);
        }
    }

    private static void printStar(int range, int x, int y) {
        if (checkSpace(range, x, y)) {
            sb.append(" ");
        } else {
            sb.append("*");
        }
    }

    private static boolean checkSpace(int range, int x, int y) {
        // 여까지 왔으면 공백이 아닌거야
        if (range == 1) {
            return false;
        }
        // 한 번이라도 이 범위에 있다면 true 리턴
        x = x % range;
        y = y % range;
        if (range / 3 < x && x <= range - range / 3 && range / 3 < y && y <= range - range / 3) {
            return true;
        }
        return checkSpace(range / 3, x, y);
    }
}