/* 
Programmers
완주하지 못한 선수
Code_By_Goun
*/

import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int n = 0; n < completion.length; n++) {
        	if (!participant[n].equals(completion[n])) {
        		answer = participant[n];
        		break;
        	}
        }
        
        if (answer.equals("")) {
        	answer = participant[participant.length - 1];
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
