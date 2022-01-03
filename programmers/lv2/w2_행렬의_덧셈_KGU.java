/* 
행렬의 덧셈
https://programmers.co.kr/learn/courses/30/lessons/12950
Code_By_Goun
*/

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr1[0].length;
        int[][] answer = new int[row][col];
        
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                answer[m][n] = arr1[m][n] + arr2[m][n];
            }
        }
        
        return answer;
    }
}