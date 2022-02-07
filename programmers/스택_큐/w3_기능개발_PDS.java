import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
  public int[] solution(int[] progresses, int[] speeds) {

    List<Integer> answerList = new ArrayList<>();
    int len = progresses.length;
    int[] toDoDate = new int[len];
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < len; i++) {
      toDoDate[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
      if (!queue.isEmpty() && toDoDate[i] > queue.peek()) {
        answerList.add(queue.size());
        queue.clear();
      }
      queue.add(toDoDate[i]);
    }
    answerList.add(queue.size());  
    return answerList.stream().mapToInt(i->i).toArray();
  }
}