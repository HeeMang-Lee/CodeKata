import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main (String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        bfs(1, visited, parent);
        for(int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
    
    public static void bfs(int start, boolean[] visited, int[] parent) {
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int next : graph.get(node)) {
                if(!visited[next]) {
                    visited[next] = true;
                    parent[next] = node;
                    q.offer(next);
                }
            }
        }
    }
}