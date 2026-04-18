import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int result = bfs(start,target);
        System.out.print(result);
    }
    
    public static int bfs(int start,int target) {
        int[] dist = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (cur == target) return dist[cur] - 1;
            
            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for(int next : nexts) {
                if(next >= 0 && next <= 100000 && dist[next] == 0) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        return -1;
    }
}