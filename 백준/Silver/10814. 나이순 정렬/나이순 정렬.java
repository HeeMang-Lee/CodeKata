import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        String[][] people = new String[testCount][2];
        for(int i = 0;  i < testCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = st.nextToken();  
            people[i][1] = st.nextToken();  
        }
        Arrays.sort(people,(a,b) -> {
            return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < people.length; i++) {
            sb.append(people[i][0]).append(' ').append(people[i][1]).append('\n');
        }
        System.out.print(sb);
    }
}