import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sba = new StringBuilder();
        StringBuilder sbb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int reversedA = Integer.parseInt(sba.append(a).reverse().toString());
        int reversedB = Integer.parseInt(sbb.append(b).reverse().toString());
        System.out.print(Math.max(reversedA,reversedB));
    }
}