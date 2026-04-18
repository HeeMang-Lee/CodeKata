import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int testCount = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < testCount ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int repeatCount = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            int len = str.length();
            for(int j = 0;  j < len ; j++) {
                sb.append(String.valueOf(str.charAt(j)).repeat(repeatCount));
            } 
            sb.append('\n');
        }
        System.out.print(sb);
    }
}