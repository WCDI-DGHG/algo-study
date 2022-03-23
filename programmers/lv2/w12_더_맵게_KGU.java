/* 
Programmers
힙(Heap)
더 맵게
Code_By_Goun
*/

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int len = scoville.length;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for (int i = 0; i < len; i++) {
        	queue.offer(scoville[i]);
        }
        
        while (queue.peek() <= K) {
            if (queue.size() == 1) return -1;
            
        	int num1 = queue.poll();	
        	int num2 = queue.poll();
        	int sum = num1 + num2 * 2; 
        	queue.offer(sum);
        	answer++;
        }
        return answer;
    }
}