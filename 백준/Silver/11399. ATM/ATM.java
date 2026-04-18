import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] atm = new int[n];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            atm[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(atm);
        for(int i = 0; i < n; i++) {
            result += atm[i] * (n - i);
        }
        
        System.out.print(result);
    }
}