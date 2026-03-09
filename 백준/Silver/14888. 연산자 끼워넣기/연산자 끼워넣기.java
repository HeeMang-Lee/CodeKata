import java.util.*;
import java.io.*;

public class Main{
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] number = new int[n];
        for(int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st1.nextToken());
        }
        int[] operator = new int[4]; // +,-,*,/
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st2.nextToken());
        }
        dfs(1,number[0],number,operator);
        System.out.println(max);
        System.out.print(min);
    }
    
    public static void dfs(int idx, int current, int[] number, int[] operator) {
    if (idx == number.length) {
        min = Math.min(min, current);
        max = Math.max(max, current);
        return;
    }

    for (int i = 0; i < 4; i++) {
        if (operator[i] > 0) {
            operator[i]--;

            if (i == 0) dfs(idx + 1, current + number[idx], number, operator);
            else if (i == 1) dfs(idx + 1, current - number[idx], number, operator);
            else if (i == 2) dfs(idx + 1, current * number[idx], number, operator);
            else if (i == 3) dfs(idx + 1, current / number[idx], number, operator);

            operator[i]++;
        }
    }
}
}