/* 
다리를 지나는 트럭
알고리즘_스택과 큐
Code_By_Goun
*/

/* 
풀이법(알고리즘) 간단 설명
[완료]	[스택]	[대기]
	7	4 5 6
	7 0	4 5 6
7	0 4	5 6
7 0	4 5	6
7 0 4	5 0	6
7 0 4 5	0 6	
=> 다리에 올라갈 수 있는 weight가 초과하면 0을 넣음
*/


import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        int len =  truck_weights.length;
        int weight_sum = 0;
        
        for (int i = 0; i < len; i++) {
        	if (weight_sum + truck_weights[i] <= weight) {
        		answer++;
        		queue.offer(truck_weights[i]);
        		weight_sum += truck_weights[i];
        	} else {
        		while (queue.size() < bridge_length) {
        			queue.offer(0);
        			answer++;
        		}
        		weight_sum -= queue.poll();
        		i--;
        	}
        }
        
        answer += bridge_length;
        
        return answer;
    }
}