import java.util.Arrays;

class Solution {
    private static int[] roots = null;

    public static int solution(int n, int[][] costs) {

        roots = new int[n];

        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        int cost = 0;
        for (int i = 0; i < costs.length; i++) {
            if (getRoot(costs[i][1]) == getRoot(costs[i][0])) {
                continue;
            }
            
            roots[getRoot(costs[i][1])] = getRoot(costs[i][0]);
            cost += costs[i][2];
        }

        return cost;
    }

    private static int getRoot(int value) {
        if (roots[value] == value) {
            return value;
        }
        return getRoot(roots[value]);
    }
}