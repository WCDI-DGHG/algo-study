import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int len = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < len; i++) {
      String[] input = sc.nextLine().split(" ");
      int loop = Integer.parseInt(input[0]);
      String val = input[1];
      for (int k = 0; k < val.length(); k++) {
        copy(loop, val.charAt(k));
      }
      System.out.println();
    }
  }

  private static void copy(int num, char val) {
    for (int i = 0; i < num; i++) {
      System.out.print(val);
    }
  }
}