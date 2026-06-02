import java.util.*;

class Solution {
    int solution(int[][] land) {
        int len = land.length;
        int[][] dp = new int[len+1][5];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) max = Math.max(dp[i-1][k],max);
                }
                dp[i][j] = land[i-1][j] + max;
            }
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(dp[len][i],answer);
        }
        return answer;
    }
}