import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[n+1];
        int[] kevin = new int[n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                kevin[i] += bfs(i,j,visited);
                Arrays.fill(visited,false);
            }
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i =1; i <= n; i++) {
            if(kevin[i] < min) {
                min = kevin[i];
                result = i;
            }
        }
        System.out.print(result);
    }
    
    public static int bfs(int start, int target, boolean[] visited) {
        if(start == target) return 0;
        q.clear();
        q.offer(start);
        visited[start] = true;
        int[] dist = new int[visited.length];
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int next : graph.get(node)) {
                if(!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[node] + 1;
                    if(next == target) return dist[next];
                    else q.offer(next);
                }
            }
        }
        return 0;
    }
}