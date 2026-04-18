import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] goods = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st2  = new StringTokenizer(br.readLine());
            goods[i][0] = Integer.parseInt(st2.nextToken());
            goods[i][1] = Integer.parseInt(st2.nextToken());
        }
        
        int[][] dp = new int[N+1][K+1];
        
        for(int i = 1; i <= N; i++) {
            int w = goods[i - 1][0];
            int v = goods[i - 1][1];
            for (int j = 0; j <= K; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.print(dp[N][K]);
    }
}