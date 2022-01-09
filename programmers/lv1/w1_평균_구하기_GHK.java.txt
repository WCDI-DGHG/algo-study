class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double arrSize = arr.length;
        double result = 0;
        for(int i = 0; i < arrSize; i++){
            result = result + arr[i];
            answer = result/arr.length;
        }
        return answer;
    }
}