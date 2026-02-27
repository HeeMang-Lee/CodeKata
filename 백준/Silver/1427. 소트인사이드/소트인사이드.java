import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        Integer[] numbers = new Integer[num.length()];
        for(int i = 0;  i < num.length(); i++) {
            numbers[i] = num.charAt(i) - '0';    
        }
        Arrays.sort(numbers, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
        }
        System.out.print(sb);
    }
}