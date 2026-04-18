import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        colorpaper(n,0,0,map);
        sb.append(white).append('\n').append(blue);
        System.out.print(sb);
    }
    static int white = 0, blue = 0;
    
    public static void colorpaper(int size, int x, int y, int[][]map) {
        int cur = map[x][y];
        boolean same = true;
        for(int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(cur != map[i][j]) {
                    same = false;
                    break;
                }
            }
            if (!same) break;    
        }
        if (same) {
            if (cur == 0) white++;
            else blue++;
        } 
        else {
            int half = size / 2;
            colorpaper(half, x, y, map);
            colorpaper(half, x + half, y, map);
            colorpaper(half, x, y + half, map);
            colorpaper(half, x + half, y + half, map);
        }
    }
}