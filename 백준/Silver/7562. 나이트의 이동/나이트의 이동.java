import java.io.*;
import java.util.*;

public class Main {
    static Queue<int[]> q = new LinkedList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());
            int[][] map = new int[l][l];
            int[][] dist = new int[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            q.clear();
            q.offer(new int[]{startX,startY});
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(st1.nextToken());
            int goalY = Integer.parseInt(st1.nextToken());
            if(startX == goalX && startY == goalY) {
                sb.append(0).append('\n');
                continue;
            }
            bfs(map,dist,l);
            sb.append(dist[goalX][goalY]).append('\n');
        }
        sb.deleteCharAt(sb.length() -1);
        System.out.print(sb);
    }
    
    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};
    public static void bfs(int[][] map,int[][] dist,int l) {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= 0  && nx < l && ny >= 0 && ny < l
                  && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}