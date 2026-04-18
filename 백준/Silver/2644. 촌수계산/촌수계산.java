import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m ; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st1.nextToken());
            int d = Integer.parseInt(st1.nextToken());
            graph.get(d).add(c);
            graph.get(c).add(d);
        }
        boolean[] visited = new boolean[n+1];
        
        System.out.print(bfs(a,b,visited));
    }
    
    public static int bfs(int a, int b, boolean[] visited) {
        if (a == b) return 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        visited[a] = true;
        int[] dist = new int[visited.length];
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int next : graph.get(node)) {
                if(!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[node] + 1;
                    if(next == b) return dist[next];
                    q.offer(next);
                }
            }
        }
        return -1;
    }
}