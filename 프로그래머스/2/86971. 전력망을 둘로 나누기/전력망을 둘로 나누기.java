import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            graph.get(a).remove(graph.get(a).indexOf(b));
            graph.get(b).remove(graph.get(b).indexOf(a));
            
            boolean[] visited = new boolean[n+1];
            int size = bfs(a, visited);
            int diff = Math.abs(n - 2 * size);
            answer = Math.min(answer, diff);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        return answer;
    }
    
    public static int bfs(int start, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
        int size = 1;
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int next : graph.get(node)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    size++;
                }
            }
        }
        return size;
    }
}