import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
            else if (cmd.equals("pop")) {
                if(stack.isEmpty()) sb.append(-1).append('\n');
                else sb.append(stack.pop()).append('\n');
            }
            else if (cmd.equals("top")) {
                if(stack.isEmpty()) sb.append(-1).append('\n');
                else sb.append(stack.peek()).append('\n');
            }
            else if (cmd.equals("size")) sb.append(stack.size()).append('\n');
            else if (cmd.equals("empty")) {
                if (stack.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
        }
        System.out.print(sb);
    }
}