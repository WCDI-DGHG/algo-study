package baekjoon;
import java.util.Scanner;
public class q1712 {
  // 손익분기점일 때의 물품 수를 n이라고 한다면
  // 구해야 할건
  // A+Bn < Cn
  // => n > A/(C-B)
  // C-B 가 0 보다 작거나 같으면? 이익을 낼 수 없다 => -1
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    //입력받음
    int A = s.nextInt();
    int B = s.nextInt();
    int C = s.nextInt();
    //최초 정답 -1
    int answer = -1;
    // 이익을 내지 못하는 경우가 아니라면
    if (C - B > 0) {
      answer = A / (C - B) + 1;
    }
    System.out.println(answer);
  }
}
