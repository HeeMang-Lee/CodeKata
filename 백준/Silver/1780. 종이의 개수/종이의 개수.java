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
        countpaper(n, 0, 0, map);
        StringBuilder sb = new StringBuilder();
        sb.append(minus).append('\n').append(zero).append('\n').append(plus);
        System.out.print(sb);
    }
    
    static int minus = 0, zero = 0, plus = 0;
    
    public static void countpaper(int size, int x, int y, int[][] map) {
        int cur = map[x][y];
        boolean same = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != cur) {
                    same = false;
                    break;
                }
            }
            if (!same) break; 
        }
        if (same) {
            if(cur == -1) minus++;
            if(cur == 0) zero++;
            if(cur == 1) plus++;
        }
        else {
            int third = size / 3;
            countpaper(third, x, y, map);
            countpaper(third ,x + third, y, map);
            countpaper(third, x + third * 2, y, map);
            countpaper(third, x , y + third, map);
            countpaper(third, x + third, y + third, map);
            countpaper(third, x + third * 2, y + third, map);
            countpaper(third, x , y + third * 2, map);
            countpaper(third, x + third, y + third * 2, map);
            countpaper(third, x + third * 2, y + third * 2, map);
        }
    }
 }