import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i = 0;  i < testCount; i++) {
            set.add(br.readLine());
        }
        String[] words = set.toArray(new String[0]);
        Arrays.sort(words,(a,b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            sb.append(words[i]).append('\n');
        }
        System.out.print(sb);
    }
}