import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int w = Integer.parseInt(st1.nextToken());
            graph.get(a).add(new int[]{b,w});
            graph.get(b).add(new int[]{a, w});
        }
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st2.nextToken());
        int v2 = Integer.parseInt(st2.nextToken());
        
        int[] dist1 = dijkstra(1, n);
        int[] distV1 = dijkstra(v1, n);
        int[] distV2 = dijkstra(v2, n);
        
        long path1 = (long)dist1[v1] + distV1[v2] + distV2[n];
        long path2 = (long)dist1[v2] + distV2[v1] + distV1[n];
        long answer = Math.min(path1, path2);
        
        if (answer >= Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(answer);
    }
    
    public static int[] dijkstra(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
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