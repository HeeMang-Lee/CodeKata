import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alphabet = new int[26];
        String s = br.readLine().toLowerCase();
        for(int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        int max = -1;
        for(int i =0; i < 26; i++) {
            if(alphabet[i] > max) {
                max = alphabet[i];
            }
        }
        for(int i=0; i < 26; i++) {
            if(max == alphabet[i]) sb.append((char)(i + 'A'));
        }
        String answer = sb.toString();
        if(answer.length() > 1) System.out.print('?');
        if(answer.length() == 1) System.out.print(answer);
    }
}