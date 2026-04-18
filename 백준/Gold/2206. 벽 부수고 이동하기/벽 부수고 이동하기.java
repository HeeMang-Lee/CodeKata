import java.util.*;
import java.io.*;

public class Main {
    static Queue<int[]> q = new LinkedList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map  = new int [n][m];
        
        for(int i =0 ; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        q.offer(new int[]{0, 0, 0});
        int[][][] dist = new int[n][m][2];
        dist[0][0][0] = 1;
        bfs(map,dist,n,m);
        int a = dist[n-1][m-1][0];
        int b = dist[n-1][m-1][1];
        if (a == 0 && b == 0) System.out.print(-1);
        else if (a == 0) System.out.print(b);
        else if (b == 0) System.out.print(a);
        else System.out.print(Math.min(a, b));
    }
    
    static int[] dx= {0,0,1,-1};
    static int[] dy= {1,-1,0,0};
    
    public static void bfs(int[][] map,int[][][] dist, int n, int m) {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int broke = cur[2];
            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && 
                    map[nx][ny] == 0 && dist[nx][ny][broke] == 0) {
                    dist[nx][ny][broke] = dist[x][y][broke] + 1;
                    q.offer(new int[]{nx,ny,broke});
                }
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && 
                    map[nx][ny] == 1 && broke == 0 && dist[nx][ny][1] == 0) {
                    dist[nx][ny][1] = dist[x][y][0] + 1;
                    q.offer(new int[]{nx,ny,1});
                }
            }
        }
    }
}