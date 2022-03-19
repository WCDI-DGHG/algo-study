/* 
Programmers
스택/큐
프린터
Code_By_Goun
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;
        int[] priArr = new int[len];
        Queue<HashMap<Character, Integer>> queue = new LinkedList<>();
        
        for (int i = 0; i < len; i++) {
        	HashMap<Character, Integer> map = new HashMap<>();
            map.put('p', priorities[i]);
            map.put('l', i);
            queue.offer(map);
            priArr[i] = priorities[i];
        }
        Arrays.sort(priArr);
        
        int maxIdx = len - 1;
        while (!queue.isEmpty()) {
        		HashMap<Character, Integer> map = queue.poll();
        		int num = map.get('p');
        		if (num == priArr[maxIdx]) {
        			answer++;
        			maxIdx--;
        			if (map.get('l') == location) {
        				return answer;
        			}
        		} else {
        			queue.offer(map);
        		}
        }
        return answer;
    }
}
