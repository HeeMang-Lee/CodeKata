import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());        
        for(int i = 0; i  < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(getLcd(n,m)).append('\n');
        }
        System.out.print(sb);
    }
    
    public static int getGcd(int n, int m) {
        while(m > 0) {
           int temp = n % m;
           n = m;
           m = temp;
        }
        return n;
    }
    public static int getLcd(int n, int m) {
        return n*m/getGcd(n,m);
    }
}