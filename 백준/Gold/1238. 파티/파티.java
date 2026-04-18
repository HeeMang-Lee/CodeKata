import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int w = Integer.parseInt(st1.nextToken());
            graph.get(a).add(new int[]{b, w});
        }
        int max = 0;
        int[] distFromX = dijkstra(x, n);
        for(int i = 1; i <= n; i++) {
            if(i == x) continue;
            int[] distToX = dijkstra(i, n);
            int temp = distToX[x];
            temp += distFromX[i];
            max = Math.max(max, temp);
        }
        System.out.print(max);
    }
    
    public static int[] dijkstra(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> a[1] - b[1]);
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