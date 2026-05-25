import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer,1);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        if(!bfs(j, k, places[i])) answer[i] = 0; 
                    }
                }
            }
        }
        return answer;
    }
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static boolean bfs(int sx, int sy, String[] place) {
        int[][] dist = new int[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        dist[sx][sy] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && dist[nx][ny] == 0 && place[nx].charAt(ny) != 'X') {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                    if (place[nx].charAt(ny) == 'P' && dist[nx][ny] <= 3) return false; 
                }
            }
        }
        return true;
    }
}