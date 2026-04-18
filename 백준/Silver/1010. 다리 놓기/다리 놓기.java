import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
       
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            long[][] dp = new long[n + 1][n + 1];
            for (int j =0; j <= n; j++) {
                dp[j][0] = 1;
                dp[j][j] = 1;
                for(int  k = 1; k < j; k++) {
                    dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
                }
            }
            long c = dp[n][r];
            sb.append(c).append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
}