/* 
Programmers
탐욕법
구명보트
Code_By_Goun
*/

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
       	while(left <= right) {
       		int sum = people[left] + people[right];
       		if (limit >= sum) {
       			left++;
       			right--;
       		} else {
       			right--;
       		}
       		answer++;
       	}
        return answer;
    }
}
