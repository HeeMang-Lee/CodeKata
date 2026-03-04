import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum =0;
        int min = -1;
        for (int i = m; i <= n; i++) {
            if(isPrime(i)) {
                sum += i;
                if(min == -1) min = i;
            }
        }
        if (min == -1) System.out.print(-1);
        else{
            System.out.println(sum);
            System.out.print(min);
        }
    }

    public static boolean isPrime(int number) {
        if(number < 2 ) return false;
        for (int i = 2; i*i <= number; i++) {
            if(number % i == 0) return false;            
        }
        return true;
    }
}