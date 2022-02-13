import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] arr = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int result[] = new int[3];
        
        for(int i = 0 ; i < arr.length ; i ++){
            for(int j = 0; j < answers.length; j ++){
                if(arr[i][(j % arr[i].length)] == answers[j]){
                    result[i]++;
                }
            }
        }
        List<Integer> maxList = new ArrayList<>();
        maxList.add(-1);
        int index = 0;
        int prev = -1;
        for(int i = 0 ; i < result.length ; i ++){
            if(prev < result[i]){
                maxList.set(index , i+1);
                prev = result[i];
                continue;
            }
            if(prev == result[i]){
                maxList.add(i+1);
                index++;
            }
        }
        return maxList.stream().mapToInt(i->i).toArray();
    }
}