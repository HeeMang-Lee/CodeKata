class Solution {
    static int count = 0;
    
    public int solution(int n) {
        int[] cols = new int[n];
        dfs(0,n,cols);
        return count;
    }
    
    public static void dfs (int row, int n, int[] cols) {
        if (row == n) {
            count++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (canPlace(row, col, cols)) {
                cols[row] = col;
                dfs(row + 1, n, cols);
            }
        }
    }
    
    public static boolean canPlace(int row, int col, int[] cols) {
        for (int r = 0; r < row; r++) {
            if(cols[r] == col) return false;
            if (Math.abs(cols[r]-col) == Math.abs(r - row)) return false;
        }
        return true;
    }
}