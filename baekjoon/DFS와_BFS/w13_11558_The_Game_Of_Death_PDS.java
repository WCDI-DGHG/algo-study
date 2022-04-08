import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int caseNum = scanner.nextInt();

        for (int i = 0; i < caseNum; i++) {
            int playerNumber = scanner.nextInt();
            getAnswer(playerNumber, scanner);
        }

    }

    private static void getAnswer(int playerNumber, Scanner scanner) {

        LinkedList<Integer>[] list = new LinkedList[playerNumber + 1];
        initLinkedList(list);

        for (int i = 0; i < playerNumber; i++) {
            int pointedOut = scanner.nextInt();
            list[i + 1].add(pointedOut);
        }
        dfs(1, list, playerNumber, 0);
    }

    private static void initLinkedList(LinkedList<Integer>[] linkedLists) {
        for (int i = 0; i < linkedLists.length; i++) {
            linkedLists[i] = new LinkedList<>();
        }
    }

    private static void dfs(int start, LinkedList<Integer>[] list, int playerNumber, int count) {
        if (count > playerNumber) {
            System.out.println(0);
            return;
        }
        if (start == playerNumber) {
            System.out.println(count);
            return;
        }

        dfs(list[start].getFirst(), list, playerNumber, count + 1);
    }

}
