/* 
자릿수 더하기
https://programmers.co.kr/learn/courses/30/lessons/12931
Code_By_Goun
*/

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n != 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}