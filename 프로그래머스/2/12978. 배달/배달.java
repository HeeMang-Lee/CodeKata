import java.util.*;

class Solution {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];
            graph.get(a).add(new int[]{b, w});
            graph.get(b).add(new int[]{a, w});
        }
        int[] dist = dijkstra(1, N);
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) answer++;
        } 
        return answer;
    }
    
    public static int[] dijkstra(int start, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1];
            if (cost > dist[node]) continue;
            
            for (int[] next : graph.get(node)) {
                int newCost = cost + next[1];
                if (newCost < dist[next[0]]) {
                    dist[next[0]] = newCost;
                    pq.offer(new int[]{next[0], newCost});
                }
            }
        }
        return dist;
    }
}