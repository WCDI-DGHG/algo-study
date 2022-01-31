/* 
Programmers
모의고사
Code_By_Goun
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] correct = {0, 0, 0};
        
        int len = answers.length;
        
        for (int i = 0; i < len; i++) {
        	if ( p1[i % p1.length] == answers[i] ) correct[0]++;
        	if ( p2[i % p2.length] == answers[i] ) correct[1]++;
        	if ( p3[i % p3.length] == answers[i] ) correct[2]++;
        }
          
        int max = correct[0];
        for (int i = 1; i < 3; i++) {
        	if (max < correct[i]) {
        		max = correct[i];
        	}
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
        	if (correct[i] == max) {
        		ans.add(i+1);
        	}
        }
        
        answer = ans.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}