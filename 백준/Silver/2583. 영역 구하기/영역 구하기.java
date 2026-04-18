import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < k; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st1.nextToken());
            int y1 = Integer.parseInt(st1.nextToken());
            int x2 = Integer.parseInt(st1.nextToken());
            int y2 = Integer.parseInt(st1.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[y][x] = 1; 
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    list.add(dfs(i, j, map, visited, m, n));
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int num : list) {
            sb.append(num).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(list.size());
        System.out.print(sb);
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static int dfs(int x,int y,int[][] map, boolean[][] visited,int m, int n) {
        visited[x][y] = true;
        int count = 1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
             if (nx >= 0 && nx < m && ny >= 0 && ny < n
            && map[nx][ny] == 0 && !visited[nx][ny]) {
                count += dfs(nx, ny, map, visited, m, n);
            }
        }
        return count;
    }
}