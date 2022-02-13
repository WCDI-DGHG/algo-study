import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    s.nextLine();
    System.out.println(s.nextLine().chars().map(v->v-48).sum());
  }
}