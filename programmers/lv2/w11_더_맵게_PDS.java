import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        while (pq.size() > 1) {
            if (pq.peek() >= K) {
                break;
            }
            pq.add(pq.poll() + (pq.poll() * 2));
            count++;
        }
        if (pq.peek() < K) {
            return -1;
        }
        return count;
    }
}