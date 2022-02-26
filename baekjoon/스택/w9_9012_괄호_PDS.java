import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputLen = Integer.parseInt(sc.nextLine());
        for (int j = 0; j < inputLen; j++) {
            String gwalHo = sc.nextLine();
            int[] countArr = new int[2];
            for (int i = 0; i < gwalHo.length(); i++) {
                if (countArr[0] < countArr[1]) {
                    break;
                }
                if (gwalHo.charAt(i) == '(') {
                    countArr[0]++;
                    continue;
                }
                countArr[1]++;
            }
            if (countArr[0] == countArr[1]) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }
}