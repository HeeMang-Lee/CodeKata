import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i =1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        boolean[] visited = new boolean[n+1];
        dfs(v,visited);
        sb.append('\n');
        visited = new boolean[n+1];
        bfs(v,visited);
        System.out.print(sb);
    }

    public static void dfs(int node,boolean[] visited) {
        visited[node] = true;
        sb.append(node).append(' ');
        for(int next : graph.get(node)) {
            if(!visited[next]) dfs(next, visited);
        }
    }

    public static void bfs(int start,boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(' ');
            for(int next : graph.get(node)) {
                if(!visited[next]) {
                    visited[next]  = true;
                    q.offer(next);
                }
            }
        }
    }
}