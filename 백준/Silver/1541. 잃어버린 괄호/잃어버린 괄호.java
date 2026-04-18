import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] groups = input.split("-");        
        int result = 0;
        
        for(String num : groups[0].split("\\+")) {
            result += Integer.parseInt(num);
        }
        
        for(int i = 1 ; i < groups.length; i++) {
            for(String num : groups[i].split("\\+")) {
                result -= Integer.parseInt(num);
            }
        }
        System.out.print(result);
    }
}