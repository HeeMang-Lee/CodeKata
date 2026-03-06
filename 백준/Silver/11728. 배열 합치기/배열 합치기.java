import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] result = new int[n+m];
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st2.nextToken());
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st3.nextToken());
        }
        int i = 0, j = 0, k = 0;
        while(i < n && j < m) {
            if(a[i] <= b[j]) result[k++] = a[i++];
            else result[k++] = b[j++];
        }
        while(i < n) result[k++] = a[i++];
        while(j < m) result[k++] = b[j++];
        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < k; idx++) {
            sb.append(result[idx]).append(' ');
        }
        System.out.print(sb);
    }
}