import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
            
        for(int i = 0; i < n; i++) {
            String unknown = br.readLine();
            set.add(unknown);
        }
        
        for(int i = 0; i < m; i++) {
            String obscure = br.readLine();
            if(set.contains(obscure)) result.add(obscure);
        }
        sb.append(result.size()).append('\n');
        Collections.sort(result);
        for (String s : result) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}