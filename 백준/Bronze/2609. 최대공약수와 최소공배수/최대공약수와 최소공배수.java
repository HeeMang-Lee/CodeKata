import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append(getGcd(n,m)).append('\n').append(n*m/getGcd(n,m));
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
}