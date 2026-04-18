import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];
        for (int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meetings, (a,b) -> {
           if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int endTime = meetings[0][1];
        int result = 1;
        for(int i = 1; i < n ; i++) {
            if (meetings[i][0] >= endTime) {
                endTime = meetings[i][1];
                result++;
            } 
        }
        System.out.print(result);
    }
}