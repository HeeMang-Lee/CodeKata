import java.util.*;

class Solution {
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        int sx = 0;
        int sy = 0;
        for(int i = 0; i < n; i++)  {
            for (int j = 0; j < m; j++) {
                char c = board[i].charAt(j);
                if (c == 'R') {
                    sx = i;
                    sy = j;
                }
            }
        }
        return bfs(sx, sy, board, n, m); 
    }
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static int bfs(int sx, int sy, String[] board, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0});
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        visited[sx][sy] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            for (int d = 0; d < 4; d++) {
                int nx = x, ny = y;
                while(true) {
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m) break;
                    if (board[tx].charAt(ty) == 'D') break;
                    nx = tx;
                    ny = ty;
                }
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (board[nx].charAt(ny) == 'G') return dist + 1;
                    q.offer(new int[]{nx,ny,dist+1});
                }
            }
        }
        return -1;
    }
}