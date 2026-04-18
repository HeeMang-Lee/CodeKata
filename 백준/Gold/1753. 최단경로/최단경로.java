import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        for(int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < e; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int w = Integer.parseInt(st1.nextToken());
            graph.get(a).add(new int[]{b,w});
        }
        int[] dist = new int[v + 1];
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
        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(dist[i]);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}