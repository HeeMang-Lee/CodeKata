import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                sticker[0][j] = Integer.parseInt(st.nextToken());
            }
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                sticker[1][j] = Integer.parseInt(st1.nextToken());
            }
            int[][] dp = new int[n+1][3];
            dp[1][0] = sticker[0][0];
            dp[1][1] = sticker[1][0];
            dp[1][2] = 0;
            if(n >= 2) {
                for(int k = 2; k <= n; k++) {
                    dp[k][0] = sticker[0][k-1] + Math.max(dp[k-1][1], dp[k-1][2]);
                    dp[k][1] = sticker[1][k-1] + Math.max(dp[k-1][0], dp[k-1][2]);
                    dp[k][2] = Math.max(dp[k-1][0], Math.max(dp[k-1][1], dp[k-1][2]));
                }
            }
            int result = Math.max(dp[n][0],dp[n][1]);
            
            sb.append(result).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}