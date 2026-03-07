import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = sol(N);
        System.out.print(result);
    }
    public static int sol(int N) {
        for(int i = 2; i < N; i++) {
            int sum = i;
            int temp = i;
            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if(sum == N) {
                return i;
            }
        }
        return 0;
    }
}