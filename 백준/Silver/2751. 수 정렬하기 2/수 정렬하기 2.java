import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        int[] num = new int[testCount];
        for(int i = 0; i < testCount; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < testCount; i++) {
            sb.append(num[i]).append('\n');
        }
        System.out.print(sb);
    }
}