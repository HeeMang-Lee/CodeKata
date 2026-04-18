import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            Deque<int[]> dq = new ArrayDeque<>();
            int[] count = new int[10];
            for(int j = 0; j < n ; j++) {
                int prior = Integer.parseInt(st.nextToken());
                count[prior]++;
                dq.addLast(new int[]{prior,j});
            }
            
            int printed = 0;
            while(!dq.isEmpty()) {
                int[] current = dq.pollFirst();
                boolean hasHigher = false;
                for (int p = current[0] + 1; p <= 9; p++) {
                    if(count[p] > 0) {hasHigher = true; break;}
                }
                if (hasHigher) {
                    dq.offerLast(current);
                } else {
                    printed++;
                    count[current[0]]--;
                    if(current[1] == target) {
                        sb.append(printed).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}