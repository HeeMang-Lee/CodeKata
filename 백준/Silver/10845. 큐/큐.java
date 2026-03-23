import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) dq.addLast(Integer.parseInt(st.nextToken()));
            else if (cmd.equals("pop")) {
                if(!dq.isEmpty()) {
                    sb.append(dq.pollFirst()).append('\n');    
                }
                else sb.append(-1).append('\n');
            }
            else if (cmd.equals("size")) sb.append(dq.size()).append('\n');
            else if (cmd.equals("empty")) {
                if(!dq.isEmpty()) {
                    sb.append(0).append('\n');
                }
                else sb.append(1).append('\n');
            }
            else if (cmd.equals("front")) {
                if(!dq.isEmpty()) {
                    sb.append(dq.peekFirst()).append('\n');
                }
                else sb.append(-1).append('\n');
            }
            else if (cmd.equals("back")) {
                if(!dq.isEmpty()) {
                    sb.append(dq.peekLast()).append('\n');
                }
                else sb.append(-1).append('\n');
            }
        }
        System.out.print(sb);
    }
}