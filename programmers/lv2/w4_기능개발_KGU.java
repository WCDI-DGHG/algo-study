/* 
기능개발
알고리즘_스택과 큐
Code_By_Goun
*/

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        int len = progresses.length;
        for (int i = 0; i < len; i++) {
        	int days = (int) Math.ceil((100 - progresses[i]) / (speeds[i]* 1.0));
        	queue.offer(days);
        }
        
        int count = 1;
        while(!queue.isEmpty()) {
        	int days = queue.poll();
        	while (queue.peek() != null && days >= queue.peek()) {
        		queue.poll();
        		count++;
        	}
        	ans.add(count);
        	count = 1;
        }

        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
}