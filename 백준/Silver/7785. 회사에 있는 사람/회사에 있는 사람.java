import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Boolean> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String attendance = st.nextToken();
            
            if(attendance.equals("enter")) {
                map.put(name,true);
            }
            else{
                map.put(name,false);
            }
        }
        List<String> result = new ArrayList<>();
        for (String name : map.keySet()) {
            if(map.get(name)) {
                result.add(name);
            }
        }
        Collections.sort(result, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String s : result) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}