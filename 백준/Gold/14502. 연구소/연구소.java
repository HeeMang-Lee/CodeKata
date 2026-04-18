import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {            
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] lab = new int[n][m];
        List<int[]> emptySpaces = new ArrayList<>();
        List<int[]> virusList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st1.nextToken());
                if(lab[i][j] == 2) virusList.add(new int[]{i, j});
                if (lab[i][j] == 0) emptySpaces.add(new int[]{i,j});
            }
        }
        
        int size = emptySpaces.size();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size-2; i++) {
            for(int j = i+1; j < size-1; j++) {
                for(int k = j+1; k < size; k++) {
                    int count = 0;
                    int[][] copy = new int[n][m];
                    for (int r = 0; r < n; r++) copy[r] = lab[r].clone();
                    
                    int[] first = emptySpaces.get(i);
                    int[] second = emptySpaces.get(j);
                    int[] third = emptySpaces.get(k);

                    copy[first[0]][first[1]] = 1;
                    copy[second[0]][second[1]] = 1;
                    copy[third[0]][third[1]] = 1;
                    
                    bfs(copy, n, m, virusList);
                    for(int a = 0; a < n; a++) {
                        for(int b = 0; b < m; b++) {
                            if(copy[a][b] == 0) count++;
                        }
                    }
                    max = Math.max(max,count);
                }
            }
        }
        System.out.print(max);
    }
        
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void bfs(int[][] map,int n, int m,List<int[]> virusList) {
        Queue<int[]> q = new LinkedList<>();
        
        for(int[] v : virusList) {
            q.offer(new int[]{v[0],v[1]});
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}