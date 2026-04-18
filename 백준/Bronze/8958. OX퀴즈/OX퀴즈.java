import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        int[] score = new int[testCount];
        for(int i =0; i < testCount; i++) {
            String ox = br.readLine();
            int len = ox.length();
            int plus = 0;
            for(int j = 0; j  < len ; j++) {
                if(ox.charAt(j) == 'O') {
                    plus++;
                    score[i] += plus;
                }
                else {
                    plus = 0;
                }
            }
        }
        for (int i = 0; i < testCount; i++) {
            System.out.println(score[i]);
        }
    }
}