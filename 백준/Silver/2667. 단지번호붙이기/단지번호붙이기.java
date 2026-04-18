import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                field[i][j] = line.charAt(j) - '0';
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(field[i][j] == 1 && !visited[i][j]) {
                    complex.add(dfs(i,j,field,visited,n));
                    count++;
                }
            }
        }
        Collections.sort(complex);
        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for(int comp : complex) {
            sb.append(comp).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<Integer> complex = new ArrayList<>();
    
    public static int dfs(int x, int y,int[][] field,boolean[][] visited,int n) {
        visited[x][y] = true;
        int size = 1;
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && field[nx][ny] == 1) {
                size += dfs(nx,ny,field,visited,n);
            }
        }
        return size;
    }
}