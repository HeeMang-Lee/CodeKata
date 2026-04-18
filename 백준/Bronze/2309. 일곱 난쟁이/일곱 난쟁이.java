import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarf = new int[9];
        int sum = 0;
        for(int i = 0; i <9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            sum += dwarf[i];
        }
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(dwarf);
        int[] result = new int[7];
        for(int i =0; i < 8; i++)  {
            for(int j = i+1; j < 9; j++) {
                if(sum - dwarf[i] - dwarf[j] == 100) {
                    for(int k = 0; k < 9; k++) {
                        if(k != i && k!= j) {
                            sb.append(dwarf[k]).append('\n');
                        }
                    }
                    System.out.print(sb);
                    return;
                }
            }
        }
    }
}