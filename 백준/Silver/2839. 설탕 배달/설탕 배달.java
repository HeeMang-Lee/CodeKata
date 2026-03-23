import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(sugar(n));
    }
    
    public static int sugar(int n) {
       int k = n/5; 
       for (int i = k; i >= 0; i--) {
           if ((n - 5 * i) % 3 == 0) return i + ((n - 5 * i)/3);       
       }
       return -1;
    }
}