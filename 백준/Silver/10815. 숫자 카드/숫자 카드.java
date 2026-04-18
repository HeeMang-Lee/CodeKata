import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        int myNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < myNum; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] result = new int[m];
        for (int i = 0;  i < m ; i++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) result[i]++; 
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(' ');
        }
        System.out.print(sb);
    }
}