import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < testCount; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());  
            int n = Integer.parseInt(st.nextToken()); 
            int k = Integer.parseInt(st.nextToken());  
            
            int[][] field = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1; 
            }
            int count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i,j,field,visited,n,m);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void dfs(int x, int y, int[][] field, boolean[][] visited, int n, int m) {
        visited[x][y] = true;
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx >=  0 && nx < n && ny >= 0 && ny < m && field[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, field, visited, n, m);
            }
        }
    }
}