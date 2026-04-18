import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        
        for (int num : arr) {
            int pos = Collections.binarySearch(list, num);
            if (pos < 0) pos = -(pos + 1);  
    
            if (pos == list.size()) {
                list.add(num);     
            } else {
                list.set(pos, num); 
            }
        }
        
        System.out.print(list.size());
    }
}