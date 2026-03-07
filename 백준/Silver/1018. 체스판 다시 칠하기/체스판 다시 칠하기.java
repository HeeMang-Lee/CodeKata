import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        char[][] chess = new char[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                chess[i][j] = line.charAt(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n-7; i++) {
            for(int j = 0; j < m-7; j++) {
                int countW = 0;
                for(int x = 0; x < 8; x++) {
                    for(int y = 0; y < 8; y++) {
                        if((x+y) % 2 == 0) {
                            if(chess[i+x][j+y] != 'W') countW++;
                        } else {
                            if(chess[i+x][j+y] != 'B') countW++;
                        }
                    }
                }
                min = Math.min(min, Math.min(countW,64-countW));
            }
        }
        System.out.print(min);
    }
}