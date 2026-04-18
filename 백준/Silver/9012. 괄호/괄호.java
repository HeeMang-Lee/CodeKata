import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            Stack<Integer> stack = new Stack<>();
            boolean valid = true;
            String command = br.readLine();
            for(int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);
                if (c == '(') stack.push(1);
                else {
                    if(stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (valid && stack.isEmpty()) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.print(sb);
    }
}