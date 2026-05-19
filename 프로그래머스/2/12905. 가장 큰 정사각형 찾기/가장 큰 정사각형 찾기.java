import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row][col];
        int answer = 0;
        for (int i = 0; i < col; i++) {
            dp[0][i] = board[0][i];
            answer = Math.max(answer, dp[0][i]);
        }
        for (int i = 0; i < row; i++) {
            dp[i][0] = board[i][0];
            answer = Math.max(answer, dp[i][0]);
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer*answer;
    }
}