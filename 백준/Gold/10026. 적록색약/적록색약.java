import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        boolean[][] visited = new boolean[n][n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, map, visited, n);
                    count++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append(' ');
        
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 'G') map[i][j] = 'R';
            }
        }
        
        boolean[][] visitedGR = new boolean[n][n];
        int countGR = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visitedGR[i][j]) {
                    dfs(i, j, map, visitedGR, n);
                    countGR++;
                }
            }
        }
        sb.append(countGR);
        System.out.print(sb);
    }
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void dfs(int x, int y, char[][] map, boolean[][] visited, int n) {
        char cur = map[x][y];
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]
               && map[nx][ny] == cur) {
                dfs(nx,ny,map,visited,n);
            }
        }
    } 
}