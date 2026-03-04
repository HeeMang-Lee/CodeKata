import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i  < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(isPrime(number)) result++;
        }
        System.out.print(result);
    }
    
    public static boolean isPrime(int number) {
        if(number < 2 ) return false;
        for (int i = 2; i*i <= number; i++) {
            if(number % i == 0) return false;            
        }
        return true;
    }
}