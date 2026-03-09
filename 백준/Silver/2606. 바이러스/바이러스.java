import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();    
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[n+1];
        dfs(1,visited);
        System.out.print(result);
    }
    
    public static void dfs(int node, boolean[] visited)  {
        visited[node] = true;
        for(int next : graph.get(node)) {
            if(!visited[next]) {
                result++;
                dfs(next, visited);
            }
        }
    }
}