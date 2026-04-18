import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        String s = br.readLine();
        for(int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == -1) {
                alphabet[s.charAt(i) - 'a'] = i;
            }
        }
        for(int i = 0; i < 26;  i++) {
            sb.append(alphabet[i]).append(' ');
        }
        System.out.print(sb);
    }
}