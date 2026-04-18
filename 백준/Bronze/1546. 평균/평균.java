import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCount = Integer.parseInt(br.readLine());
        int sum = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numCount; i++) {
            int score = Integer.parseInt(st.nextToken());
            sum += score;
            max = Math.max(max,score);
        }
        double answer = (double) sum / numCount / max * 100 ;
        System.out.print(answer);
    }
}