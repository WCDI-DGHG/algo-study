/* 
Programmers
해시
완주하지 못한 선수
Code_By_Goun
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for (String player : participant) {
        	map.put(player, map.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
        	map.put(player, map.get(player) - 1);
        }
        
        for (String key : map.keySet()) {
        	if(map.get(key) != 0) {
        		answer = key;
        		return answer;
        	}
        }
        return answer;
    }
}

public class Main{
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion1 = {"eden", "kiki"};
		System.out.println(s.solution(participant1, completion1));

		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(s.solution(participant2, completion2));
		
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		System.out.println(s.solution(participant3, completion3));
	}
}
