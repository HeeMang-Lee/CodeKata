import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int row = triangle.length;
        int col = triangle[row-1].length;
        int[][] dp = new int[row][col];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < i+1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < row; i++) {
            if (max < dp[row-1][i]) max = dp[row-1][i];
        }
        return max;
    }
}