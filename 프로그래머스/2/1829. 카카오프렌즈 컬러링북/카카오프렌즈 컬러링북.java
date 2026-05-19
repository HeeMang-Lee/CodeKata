import java.util.*;

class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfArea = 0;
        
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = picture[i][j];
            }
        }
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    numberOfArea++;
                    int size = dfs(i,j,map,visited,m,n);
                    maxSizeOfArea = Math.max(maxSizeOfArea, size);
                }
            }
        }
        
        return new int[]{numberOfArea,maxSizeOfArea};
    }
    
    public int dfs(int x, int y, int[][] map, boolean[][] visited, int m, int n) {
        visited[x][y] = true;
        int count = 1;
        int cur = map[x][y];
        for (int d = 0; d < 4; d++) {
                 int nx = x + dx[d];
                  int ny = y + dy[d];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] == cur) {
                    count += dfs(nx,ny,map,visited,m,n);
                }
        }
        return count;
    }
}