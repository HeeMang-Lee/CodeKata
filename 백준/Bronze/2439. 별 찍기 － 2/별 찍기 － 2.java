import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  
        drawStar(n,1);
        System.out.print(sb);
    }
    
    public static void drawStar(int n,int current) {
        if (current > n) return;
        for (int i = 0; i < n - current; i++) {
            sb.append(' ');
        }
        for (int i = 0; i < current; i++) {
            sb.append('*');
        }
        sb.append('\n');
        drawStar(n,current+1);    
    }

}
