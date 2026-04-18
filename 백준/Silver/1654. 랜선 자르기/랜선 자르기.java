import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cable = new int[k];
        
        for (int i = 0; i < k; i++) {
            cable[i] = Integer.parseInt(br.readLine());
        }
        
        long lo = 1;
        long hi  = Arrays.stream(cable).max().getAsInt();
        
        while(lo <= hi) {
            long mid = (lo + hi) / 2;
            long count = 0;
            for (int i = 0; i < k; i++) {
                count += cable[i] / mid;
            }
            if (n <= count) lo = mid+1;
            else hi = mid -1;
        }
        
        System.out.print(hi);
    }
}