/* 
N개의 최소공배수
https://programmers.co.kr/learn/courses/30/lessons/12953#
Code_By_Goun
*/

import java.util.ArrayList;

// 실패(시간초과)
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        int len = arr.length;
        int[] result = arr;
        
        // 100이하인 소수(1제외)
        int[] primeNums = {2, 3, 5, 7};
        int success = 0;
        boolean oneMore = false;
        
        // 모든 수들을 나눌 수 있는 최소 숫자 찾기
        for (int n = 0; n < 4; n++) {
            if (oneMore == false) {
                for (int m = 0; m < len; m++) {
                    if (arr[m] % primeNums[n] == 0) {
                        success++;
                    }
                    result[m] = arr[m] / primeNums[n];
                }
            } else {
                for (int m = 0; m < len; m++) {
                    if (result[m] % primeNums[n] == 0) {
                        success++;
                    }
                    arr[m] = result[m] / primeNums[n];
                }
            }
            
            if (success > 1) {
                answer *= primeNums[n];
                success = 0;
                oneMore = !oneMore;
                n = -1;
            }
        }
        
        for (int j = 0; j < len; j++) {
            answer *= arr[j];
        }
        
        return answer;
    }
}