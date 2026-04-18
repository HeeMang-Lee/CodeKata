import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] tri = new int[t][t];
        
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[t+1][t+1];
        
        if(t == 1) {
            System.out.print(tri[0][0]);
            return;
        }
        dp[1][1] = tri[0][0];
        if(t >= 2) {
            for(int i = 2; i <= t; i++) {
                for(int j = 1; j <= i; j++) {
                    if (j == 1) {
                        dp[i][j] = dp[i-1][j] + tri[i-1][j-1];
                    }
                    else if (j == i) {
                        dp[i][j] = dp[i-1][j-1] + tri[i-1][j-1];
                    }
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + tri[i-1][j-1];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= t; i++) {
            max = Math.max(max, dp[t][i]);
        }
        
        System.out.print(max);
    }
}