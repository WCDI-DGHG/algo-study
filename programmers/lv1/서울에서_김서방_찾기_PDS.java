public class 서울에서_김서방_찾기 {
  public String solution(String[] seoul) {
    for (int i = 0; i < seoul.length; i++) {
      if ("Kim".equals(seoul[i])) {
        return "김서방은 " + i + "에 있다";
      }
    }
    return "";
  }
}