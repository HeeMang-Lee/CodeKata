import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
           if (Math.abs(a) != Math.abs(b)) return Math.abs(a) - Math.abs(b);
            return a - b;
        });
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0) pq.offer(x);
            if(x == 0) {
                if(!pq.isEmpty()) {
                    sb.append(pq.poll()).append('\n');
                } 
                else sb.append(0).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}