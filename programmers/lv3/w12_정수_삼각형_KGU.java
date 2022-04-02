/* 
Programmers
동적계획법(Dynamic Programming)
정수 삼각형
Code_By_Goun
*/

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int yLen = triangle.length;
        int xLen = triangle[yLen-1].length;
        Integer[][] DP = new Integer[xLen][yLen];
        
        DP[0][0] = triangle[0][0];
        DP[1][0] = triangle[0][0] + triangle[1][0];
        DP[1][1] = triangle[0][0] + triangle[1][1];
        
        for (int x = 2; x < xLen; x++) {
        	DP[x][0] = DP[x-1][0] + triangle[x][0];
        	for (int y = 1; y < x && y < yLen; y++) {
        		DP[x][y] = Math.max(DP[x-1][y-1], DP[x-1][y]) + triangle[x][y];
        	}
        	DP[x][x] = DP[x-1][x-1] + triangle[x][x];
        }
        
        for (int y = 0; y < yLen; y++) {
        	answer = Math.max(DP[xLen-1][y], answer);
        }
        return answer;
    }
}