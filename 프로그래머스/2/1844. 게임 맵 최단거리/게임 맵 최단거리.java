import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        bfs(0,0,maps,dist,n,m);
        if(dist[n-1][m-1] != 0) return dist[n-1][m-1];
        else return -1;
    }
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void bfs(int sx, int sy, int[][] maps, int[][] dist, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        dist[sx][sy] = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}