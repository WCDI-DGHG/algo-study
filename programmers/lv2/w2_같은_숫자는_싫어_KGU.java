import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        arrList.add(arr[0]);
        
        for (int i = 1, m = 0; i < arr.length; i++) {
            if (arrList.get(m) == arr[i]) {
                continue;
            }
            arrList.add(arr[i]);
            m++;
        }
        
        int sizeOfList = arrList.size();
        answer = new int[sizeOfList];
        for(int i = 0; i < sizeOfList; i++) {
            answer[i] = arrList.get(i);
        }

        return answer;
    }
}