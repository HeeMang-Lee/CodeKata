import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) { sb.append("1 0\n"); continue; }
            if (n == 1) { sb.append("0 1\n"); continue; }
            int[][] dp = new int[n+1][2];
            dp[0] = new int[]{1, 0}; 
            dp[1] = new int[]{0, 1}; 
            for(int j = 2; j <= n; j++) {
                dp[j][0] = dp[j-1][0] + dp[j-2][0];
                dp[j][1] = dp[j-1][1] + dp[j-2][1];
            }
            sb.append(dp[n][0]).append(' ').append(dp[n][1]).append('\n');
        }
        System.out.print(sb);
    }
}