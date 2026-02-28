import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nArray = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nArray[i] = num;
        }
        Arrays.sort(nArray);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] result = new int[m];
        for (int i = 0;  i < m ; i++) {
            int isTrue = Arrays.binarySearch(nArray, Integer.parseInt(st.nextToken()));
            if (isTrue >= 0) result[i] = 1;
            else result[i] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append('\n');
        }
        System.out.print(sb);
    }
}