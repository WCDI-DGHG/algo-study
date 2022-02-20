class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers , target, numbers[0] , 1) + dfs(numbers ,target, -numbers[0] , 1);
    }
    public int dfs(int[] arr ,int target, int sum , int index ){
        if(arr.length == index){
            return (sum==target) ? 1 : 0;
        }
        return dfs(arr , target , sum+arr[index] , index+1) + dfs(arr,target,sum-arr[index], index+1);
    }
}