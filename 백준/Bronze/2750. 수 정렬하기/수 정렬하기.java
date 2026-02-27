import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        Integer[] num = new Integer[testCount];
        for(int i = 0; i < testCount; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        for(int i = 0; i < testCount; i++) {
            System.out.println(num[i]);
        }
    }
}