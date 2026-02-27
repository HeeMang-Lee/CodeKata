import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[10];
        Arrays.fill(num, 0);
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int product = a*b*c;
        while(product > 0) {
            int rem = product % 10;
            product = product / 10;
            num[rem]++;
        }
        for(int i = 0 ; i < 10; i++) {
            System.out.println(num[i]);
        }
    }
}