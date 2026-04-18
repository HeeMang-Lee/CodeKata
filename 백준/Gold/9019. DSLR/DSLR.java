import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];
            String[] path = new String[10000];
            path[start] = "";
            sb.append(bfs(start,target,visited,path)).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
    
    static Queue<Integer> q = new LinkedList<>();
    public static String bfs(int start,int target,boolean[] visited,String[] path) {
        q.clear();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            int[] nexts = new int[4];
            nexts[0] = (cur * 2) % 10000;                       
            nexts[1] = cur == 0 ? 9999 : cur - 1;                
            nexts[2] = (cur % 1000) * 10 + cur / 1000;            
            nexts[3] = (cur % 10) * 1000 + cur / 10;
            char[] cmds = {'D', 'S', 'L', 'R'};
            
            for(int d = 0; d < 4; d++) {
                if(!visited[nexts[d]]) {
                    visited[nexts[d]] = true;
                    path[nexts[d]] = path[cur] + cmds[d];
                    q.offer(nexts[d]);
                    if (nexts[d] == target) return path[target];
                }
            }
        }
        return "";
    }
}