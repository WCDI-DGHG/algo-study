class Solution {
    public int[] solution(int n, int m) {
        int result = csgys(n,m);
        return new int[]{result, mul(n,m) / result };
    }
    
    private int mul(int x , int y){
        return x * y;
    }
    private int csgys(int x , int y){
        int result = 1;
        for(int i = 1 ; i <= Math.min(x,y); i ++){
            if(x % i == 0 && y % i == 0){
                result = i;
            }
        }
        return result;
    }
}