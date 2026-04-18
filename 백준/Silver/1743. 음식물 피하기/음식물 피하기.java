import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        
        for(int i = 0; i < k; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken()) - 1;
            int y = Integer.parseInt(st1.nextToken()) - 1;
            map[x][y] = 1;
        }
        
        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, dfs(i, j, map, visited, n, m));
                }
            }
        }
        System.out.print(max);        
    }
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static int dfs (int x,int y,int[][] map, boolean[][] visited,int n,int m) {
        visited[x][y] = true;
        int count = 1;
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m
            && map[nx][ny] == 1 && !visited[nx][ny]) {
                count += dfs(nx, ny, map, visited, n, m);
            }
        }
        return count;
    }
}