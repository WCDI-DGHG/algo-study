/* 
Programmers
힙(Heap)
이중우선순위큐
Code_By_Goun
*/

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        int len = operations.length;
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i = 0; i < len; i++) {
        	StringTokenizer st = new StringTokenizer(operations[i]);
        	
        	String order = st.nextToken();
        	int num = Integer.parseInt(st.nextToken());
        	if (order.equals("I")) {
        		maxQueue.offer(num);
        		minQueue.offer(num);
        	} else if (!minQueue.isEmpty()) {
        		if (num == 1) {
        			int n = maxQueue.poll();
        			minQueue.remove(n);
        		} else {
        			int n = minQueue.poll();
        			maxQueue.remove(n);
        		}
        	}
        }
        
        if (!minQueue.isEmpty()) {
        	answer[0] = maxQueue.peek();
        	answer[1] = minQueue.peek();
        }
        return answer;
    }
}