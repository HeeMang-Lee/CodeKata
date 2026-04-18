import java.util.*;
import java.io.*;

public class Main {
    static Queue<int[]> q = new LinkedList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] tomato = new int[h][n][m];
        int[][][] dist = new int[h][n][m];
        
        for (int i = 0; i < h; i++) {          
            for (int j = 0; j < n; j++) {      
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {  
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                        dist[i][j][k] = 1;
                        }
                    }
                }
            }
        bfs(tomato, dist, n, m, h);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if (tomato[i][j][k] == 0 && dist[i][j][k] == 0) {
                        System.out.print(-1);
                        return;
                }
                    max = Math.max(max, dist[i][j][k]);
                }
            }
        }
        System.out.print(max - 1);
    }
     
    
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    public static void bfs(int[][][] tomato, int[][][] dist, int n, int m, int h) {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];
            for(int d = 0; d < 6; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nz = z + dz[d];
                if (nx >= 0 && nx < h && ny >= 0 && ny < n && nz >= 0 && nz < m
                   && tomato[nx][ny][nz] == 0 && dist[nx][ny][nz] == 0) {
                    dist[nx][ny][nz] = dist[x][y][z] + 1;
                    q.offer(new int[]{nx,ny,nz});
                }
            }
        }
    }
}
