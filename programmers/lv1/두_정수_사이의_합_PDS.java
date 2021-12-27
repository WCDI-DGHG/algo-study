// Solution
public class 두_정수_사이의_합 {
  
  public long solution(int a, int b) {
    long min = Math.min(a, b);
    long max = Math.max(a, b);
    long answer = (min + max) * (max - min + 1) / 2;
    return answer;
  }
}