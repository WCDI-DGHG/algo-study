import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 입력 문자열을 캐릭터 배열로 바꿔줌
    char[] input = new Scanner(System.in).nextLine().toUpperCase().toCharArray();
    // 모든 알파벳 개수에 대한 배열 
    int[] countArr = new int[26];

    // 알파벳 나온 갯수만큼 배열에 더해줌
    for (int i = 0; i < input.length; i++) {
      countArr[input[i] - 65]++;
    }
    
    int max = -1;
    String answer = "?";
    
    for (int i = 0; i < countArr.length; i++) {
      if (max < countArr[i]) {
        max = countArr[i];
        answer = (char)(i+65) + "";
      } else if (max == countArr[i]) {
        answer = "?";
      }
    }
    System.out.println(answer);
  }
}