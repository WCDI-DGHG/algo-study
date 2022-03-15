import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		pq.addAll(Arrays.stream(priorities)
                  .boxed()
                  .collect(Collectors.toList()));

		Deque<Integer> dq = new LinkedList<>();
		dq.addAll(Arrays.stream(priorities)
                  .boxed()
                  .collect(Collectors.toList()));

		Deque<Integer> indexDq = new LinkedList<>();
		AtomicInteger atomicInteger = new AtomicInteger();
		indexDq.addAll(Arrays.stream(priorities)
                       .map(v -> atomicInteger.getAndIncrement())
                       .boxed()
                       .collect(Collectors.toList()));

		int current = 0;
		while (!pq.isEmpty()) {
			if (pq.peek() == dq.peekFirst()) {
				answer++;
				if (indexDq.peekFirst() == location) {
					break;
				}
				pq.poll();
				dq.pollFirst();
				indexDq.pollFirst();
				continue;
			}
			dq.addLast(dq.pollFirst());
			indexDq.addLast(indexDq.pollFirst());
		}
		return answer;
	}
}