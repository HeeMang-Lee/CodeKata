import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] computers) {
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        boolean[] visited = new boolean[n+1];
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i,visited);
                count++;
            }
        }
        return count;
    }
    
    public static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if(!visited[next]) dfs(next,visited);
        }
    }
}