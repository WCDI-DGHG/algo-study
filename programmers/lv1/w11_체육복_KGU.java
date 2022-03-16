/* 
Programmers
탐욕법
체육복
Code_By_Goun
*/

import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] stuArr = new int[n+1];
        Arrays.sort(reserve);
        
        int lostLen = lost.length;
        int reLen = reserve.length;
        
        for (int i = 0; i < lostLen; i++) {
        	stuArr[lost[i]] = -1;
        }
        
        for (int i = 0; i < reLen; i++) {
        	stuArr[reserve[i]]++;
        }
        
        for (int i = 0; i < reLen; i++) {
        	int cur = reserve[i];
        	
        	if (stuArr[cur] == 1) {
	        	if (cur > 1 && stuArr[cur - 1] == -1) {
	    			stuArr[cur - 1]++;
	    		} else if(cur + 1 <= n && stuArr[cur + 1] == -1) {
	    			stuArr[cur + 1]++;
	    		}
	        	stuArr[cur]--;
        	}
   
        }
        
        for (int i = 1; i <= n; i++) {
        	if (stuArr[i] == 0) answer++;
        }
        
        return answer;
    }
}
