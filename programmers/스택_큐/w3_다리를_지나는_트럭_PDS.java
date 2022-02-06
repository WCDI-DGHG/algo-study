import java.util.LinkedList;
import java.util.Queue;
class Solution {
  public static int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    Queue<Integer> currentQueue = new LinkedList<>();

    // 트럭무게 배열 index
    int index = 0;
    // 흘러갈 시간
    int sec = 0;
    // 다리를 건넌 트럭의 수이자 현재 넣어야 할 트럭의 인덱스이기도 하다.
    int count = 0;
    // 다리위에 있는 트럭들 무게의 합.
    int tempWeight = 0;

    while (true) {
      // 모든 트럭이 다리를 지나가면 반복문 종료
      if (count == truck_weights.length) {
        break;
      }
      // 경과시간 - 가장 처음 추가된 트럭이 추가된 시점이 다리 길이면
      // 해당 트럭은 다리를 건넌 것이다.
      // 큐에서 해당 트럭이 다리로 올라온 시점을 빼줘야함.
      // 그래야 다음 트럭에 대해 계산 가능
      if (!currentQueue.isEmpty() && sec - currentQueue.peek() == bridge_length) {
        // 현재 다리위에 있는 트럭들의 무게에서 빼줘야함.
        tempWeight -= truck_weights[count];
        // 다리를 건넌 트럭 수를 추가해준다.
        count++;
        //큐에서 지금 빼는 트럭이 다리에 올라온 시점을 빼줌
        currentQueue.poll();
      }

      // 현재 다리에 있는 트럭들의 무게에 새로운 트럭을 추가해도
      // 혀옹 무게를 넘지 않으면 추가해준다.
      // 이미 마지막 트럭도 넣었으면 그만 한다.
      if (index!= truck_weights.length && weight >= truck_weights[index] + tempWeight) {
        tempWeight += truck_weights[index++];
        // 트럭이 추가 될 때의 경과시간을 큐에 넣어줌
        currentQueue.add(sec);
      }
      // 시간은 계속 흘러감
      sec++;

    }
    return sec;
  }
}