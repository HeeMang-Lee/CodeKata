import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        while(true) {
            boolean[][] toRemove = new boolean[m][n];
            for(int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    char c = board[i].charAt(j);
                    if (c == '.') continue;
                    if(board[i+1].charAt(j) == c && board[i].charAt(j+1) == c && board[i+1].charAt(j+1) == c) {
                        toRemove[i][j] = true;
                        toRemove[i+1][j] = true;
                        toRemove[i][j+1] = true;
                        toRemove[i+1][j+1] = true;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n; j++) {
                    if (toRemove[i][j]) {
                        board[i] = board[i].substring(0, j) + "."+ board[i].substring(j+1);
                        sum++;
                    }
                }
            }
            answer += sum;
            if(sum == 0) break;
            
            char[][] grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                grid[i] = board[i].toCharArray();
            }
            for(int j = 0; j < n; j++) {
                char[] col = new char[m];
                Arrays.fill(col, '.');
                int idx = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (grid[i][j] != '.') {
                        col[idx] = grid[i][j];
                        idx--;
                    }
                }
                for (int i = 0; i < m; i++) {
                    grid[i][j] = col[i];
                }
            }
            for (int i = 0; i < m; i++) {
                board[i] = new String(grid[i]);
            }
        }
        return answer;
    }
}