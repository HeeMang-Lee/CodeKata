import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }
                if (maps[i].charAt(j) == 'L') {
                    lx = i;
                    ly = j;
                }
                if (maps[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        int distL = bfs(sx,sy,lx,ly,maps,n,m);
        int distE = bfs(lx,ly,ex,ey,maps,n,m);
        if (distL == 0 || distE == 0) return -1;
        return distL + distE - 2;
    }
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static int bfs (int sx, int sy, int ex, int ey, String[] maps,int n,int m) {
        int[][] dist = new int [n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        dist[sx][sy] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx].charAt(ny) != 'X' 
                    && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return dist[ex][ey];
    }
}