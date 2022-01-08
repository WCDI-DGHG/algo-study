import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    boolean[] arr = new boolean[10036];
    for (int i = 1; i < 10001; i++) {
      arr[getSelfNum(i)] = true;
    }
    for(int i = 1 ; i < 10001; i ++) {
      if(!arr[i]) {
        System.out.println(i);
      }
    }
  }
  private static int getSelfNum(int number) {
    return number + (number + "").chars().map(v -> v - 48).sum();
  }
}