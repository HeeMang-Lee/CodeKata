import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int sx = 0, sy = 0;  

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i; sy = j;
                    map[i][j] = 0;  
                }
            }
        }

        int sharkSize = 2;
        int eatCount = 0;
        int time = 0;

        while (true) {
            
            int[][] dist = new int[n][n];
            for (int[] row : dist) Arrays.fill(row, -1);
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{sx, sy});
            dist[sx][sy] = 0;

            List<int[]> candidates = new ArrayList<>();

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && dist[nx][ny] == -1
                        && map[nx][ny] <= sharkSize) {
                        dist[nx][ny] = dist[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                        if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                            candidates.add(new int[]{dist[nx][ny], nx, ny});
                        }
                    }
                }
            }

            if (candidates.isEmpty()) break;  

            candidates.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                if (a[1] != b[1]) return a[1] - b[1];
                return a[2] - b[2];
            });

            int[] target = candidates.get(0);
            time += target[0];
            sx = target[1];
            sy = target[2];
            map[sx][sy] = 0;  
            
            if (++eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.print(time);
    }
}