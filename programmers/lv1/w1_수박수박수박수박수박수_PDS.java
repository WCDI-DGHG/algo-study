public class Solution {
  public String solution(int n) {
    String answer = "";
    String[] text = {"수", "박"};
    for (int i = 0; i < n; i++) {
      answer += text[i % 2];
    }
    return answer;
  }
}