/* 
주식가격
Code_By_Goun
*/

import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<Integer>();
        int len = prices.length;
        answer = new int[len];
        
        for (int i = 0; i < len; i++) {
        	if (stack.isEmpty()) {
        		stack.push(i);
        	} else {
        		int index = stack.pop();
        		while (prices[index] > prices[i]) {
        			answer[index] = i - index;
        			if (!stack.isEmpty()) {
        				index = stack.pop();
        			} else {
        				index = i;
        			}
        		}
        		
        		if(index != i) {
        			stack.push(index);
        		}
        		stack.push(i);
        	}
        }
        
        while (!stack.isEmpty()) {
        	int index = stack.pop();
        	answer[index] = (len - 1) - index;
        }
                
        return answer;
    }
}