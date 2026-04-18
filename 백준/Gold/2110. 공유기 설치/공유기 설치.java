import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        for(int i = 0 ; i < n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x);
        int lo = 1;
        int hi = x[n-1] - x[0];
        
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int count = 1;
            int start = x[0];
            for(int i = 1; i < n; i++) {
                if(x[i] >= mid + start) {
                    start = x[i];
                    count++;
                }
            }
            if(count >= c) lo = mid + 1;
            else hi = mid - 1;
        }
        
        System.out.print(hi);
    } 
}