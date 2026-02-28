import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] result = new int[m];
        for (int i = 0;  i < m ; i++) {
            result[i] = map.getOrDefault(Integer.parseInt(st.nextToken()),0);
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(' ');
        }
        System.out.print(sb);
    }
}