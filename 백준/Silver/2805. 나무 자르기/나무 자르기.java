import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] woods = new int[n];
        for(int i = 0; i < n; i++) {
            woods[i] = Integer.parseInt(st2.nextToken());
        }
        long lo = 1;
        long hi = Arrays.stream(woods).max().getAsInt();
        while(lo <= hi) {
            long mid = (lo + hi) / 2;
            long count = 0;
            for(int i = 0; i < n; i++) {
                if (woods[i] > mid) count += woods[i] - mid;
            }
            if (count >= m) lo = mid +1;
            else hi = mid - 1;
        }
        
        System.out.print(hi);
    }
}