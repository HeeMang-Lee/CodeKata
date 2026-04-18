import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = Integer.MIN_VALUE;
        for(int h = 0; h <= 100; h++) {
            boolean[][] visited = new boolean[n][n];
            int count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] > h && !visited[i][j]) {
                        dfs(i,j,map,visited,n,h);
                        count++;
                    }
                }
            }
            max = Math.max(max,count);
        }
        System.out.print(max);
    }
        
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void dfs(int x,int y, int[][] map,boolean[][] visited,int n,int h) {
        visited[x][y] = true;
        for(int d = 0; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n &&
              map[nx][ny] > h && !visited[nx][ny]) {
                dfs(nx,ny,map,visited,n,h);
            }
        }
    }
}