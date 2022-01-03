class Solution {
    public int solution(int[] arr) {
        int prev = arr[0];
        int answer = 1;
        for(int i = 1 ; i < arr.length; i ++){
            answer = (mul(prev , arr[i]) / gcf(prev,arr[i]));
            prev = answer;
        }
        return answer;
    }
    public int gcf(int x, int y){
        int result = 1;
        for(int i = 1; i <= Math.min(x,y); i ++){
            if(y % i == 0 && x % i == 0) {
                result = i;
            }
        }
        return result;
    }
    public int mul(int x, int y){
        return x*y;
    }
}