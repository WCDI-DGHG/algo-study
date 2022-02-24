/* 
Programmers
해시
전화번호 목록
Code_By_Goun
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Integer> map = new HashMap<>();
        int len = phone_book.length;
        for (int i = 0; i < len; i++) {
        	map.put(phone_book[i], i);
        }
        
        for (int m = 0; m < len; m++) {
        	for (int n = 0; n < phone_book[m].length(); n++) {
        		if (map.containsKey(phone_book[m].substring(0, n))) {
        			answer = false;
        		}
        	}
        }
        return answer;
    }
}
