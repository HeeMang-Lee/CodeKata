import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 1; i < n+1; i++) {
            dq.addLast(i);
        }
        
        while(dq.size() > 1) {
            dq.pollFirst();
            int temp = dq.pollFirst();
            dq.addLast(temp);
        }
        
        System.out.print(dq.poll());
    }
}