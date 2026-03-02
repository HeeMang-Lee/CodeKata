import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = br.readLine()).equals(".")) {
            Stack<Integer> stack = new Stack<>();
            boolean valid = true;
            for (int i = 0 ; i < line.length(); i++) {
                char c = line.charAt(i);
                if(c == '[') stack.push(1);
                else if (c == ']') {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    } else if (stack.peek() == 1) stack.pop();
                    else {
                        valid = false;
                        break;
                    }
                }
                else if (c ==  '(') stack.push(2);
                else if (c == ')') {
                    if(stack.isEmpty()) {
                        valid = false;
                        break;
                    } else if (stack.peek() == 2) stack.pop();
                    else {
                        valid = false;
                        break;
                    }
                }
            }
        if (valid && stack.isEmpty()) sb.append("yes").append('\n');
        else sb.append("no").append('\n');
        }
        System.out.print(sb);
    }
}