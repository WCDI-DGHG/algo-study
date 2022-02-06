import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int temp = arr[0];
        for(int i = 1 ; i < arr.length; i ++){
            if(temp == arr[i]){
                arr[i] = -1;
                continue;
            }
            temp = arr[i];
        }
        return Arrays.stream(arr).filter( v -> v != -1).toArray();
    }
}