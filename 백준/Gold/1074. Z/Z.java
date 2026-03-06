import java.util.*;
import java.io.*;

public class Main{
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        z(n,0,0,r,c);
    }
    
    public static void z(int n, int x, int y,int r, int c) {
        if (n == 0) {
            System.out.print(count);
            return;
        }
        
        int half = (1<< (n-1));
        if(r < x + half && c < y + half) {
            z(n-1,x,y,r,c);
        }
        else if(r < x + half && c >= y+ half) {
            count += half*half;
            z(n-1,x,y+half,r,c);
        } else if(r >= x + half && c < y+half) {
            count += 2*half*half;
            z(n-1,x + half,y,r,c);
        } else {
            count += 3*half*half;
            z(n-1,x+half,y+half,r,c);
        }    
    }
}