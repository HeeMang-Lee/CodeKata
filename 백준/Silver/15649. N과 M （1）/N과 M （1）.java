import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        for(int i =0; i < n; i++ ) {
            arr[i] = i+1;
        }
        int[] output = new int[m];
        boolean[] visited = new boolean[n];
        perm(arr,output,visited,0,n,m);
        System.out.print(sb);
    }
    
    public static void perm(int[] arr,int[] output,boolean[] visited,int depth,int n,int m){
        
        if (depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        
        for(int i =0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr,output,visited,depth +1,n,m);
                visited[i] = false;
            }
        }
    }
}