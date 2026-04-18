class Solution {
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        max = 0;
        boolean[] visited = new boolean[dungeons.length];
        dfs(0, k, dungeons, visited);
        return max;
    }
    
    public static void dfs(int depth, int k, int[][] dungeons, boolean[] visited) {
        max = Math.max(max, depth);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }
        }
    }
}