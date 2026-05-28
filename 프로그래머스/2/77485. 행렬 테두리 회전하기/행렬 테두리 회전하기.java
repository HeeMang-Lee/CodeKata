import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num;
                num++;
            }
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotation(map,queries[i]);
        }
        return answer;
    }
    
    public static int rotation (int[][] map, int[] query) {
        int r1 = query[0] - 1, c1 = query[1] -1,  r2 = query[2] - 1, c2 = query[3] -1;
        
        int temp = map[r1][c1];
        int min = temp;
        
        for (int i = r1; i < r2; i++) {
            map[i][c1] = map[i+1][c1];
            min = Math.min(min, map[i][c1]);
        }
        
        for (int j = c1; j < c2; j++) {
            map[r2][j] = map[r2][j+1];
            min = Math.min(min,map[r2][j]);
        }
        
        for (int i = r2; i > r1; i--) {
            map[i][c2] = map[i-1][c2];
            min = Math.min(min,map[i][c2]);
        }
        
        for (int j = c2; j > c1; j--) {
            map[r1][j] = map[r1][j-1];
            min = Math.min(min, map[r1][j]);
        }
        map[r1][c1+1] = temp;
        return min;
    }
}