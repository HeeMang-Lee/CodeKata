class Solution {
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int[] sub = new int[2];
        sub = dfs(board,aloc,bloc);
        return sub[1];
    }
    
    public static int[] dfs (int[][] board, int[] myloc, int[] opploc) {
        int n = board.length, m = board[0].length;
        int mx = myloc[0], my = myloc[1];
        if (board[mx][my] == 0) return new int[]{0, 0};
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean canMove = false;
        for (int d = 0; d < 4; d++) {
            int nx = mx + dx[d];
            int ny = my + dy[d];
            if (nx >= 0 && ny >=0 && nx < n && ny < m && board[nx][ny] == 1) {
                canMove = true;
                break;
            }
        }
        if (!canMove) return new int[]{0,0};
        
        boolean canWin = false;
        int minWinTurn = Integer.MAX_VALUE;
        int maxLoseTurn = 0;
        
        for (int d = 0; d < 4; d++) {
            int nx = mx + dx[d];
            int ny = my + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (board[nx][ny] == 0) continue;
            board[mx][my] = 0;
            
            int[] sub = dfs(board,opploc,new int[]{nx,ny});
            board[mx][my] = 1;
            
            if (sub[0] == 0) {
                canWin = true;
                minWinTurn = Math.min(minWinTurn, sub[1] + 1);
            } else {
                maxLoseTurn = Math.max(maxLoseTurn, sub[1] + 1);
            }
        }
        
        if (canWin) return new int[]{1,minWinTurn};
        return new int[]{0,maxLoseTurn};
    }
}