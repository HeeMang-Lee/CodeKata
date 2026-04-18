import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int move = (1 << n) - 1;
        sb.append(move).append('\n');
        hanoi(n,1,3,2);
        System.out.print(sb);
    }
    
    public static void hanoi(int n, int from, int to, int mid) {
        if(n == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return ;
        }
        hanoi(n-1, from, mid, to);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(n-1, mid, to, from);
    }
}