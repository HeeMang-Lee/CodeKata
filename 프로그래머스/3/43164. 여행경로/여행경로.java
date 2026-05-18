import java.util.*;

class Solution {
    static String[] answer;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        answer = null;
        visited =  new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {          
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]); 
        });
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", path, 0, tickets);
        
        return answer;
    }
    
    public static void dfs (String current, List<String> path, int count, String[][] tickets) {
        if (answer != null) return;
        if (count == tickets.length ) {
            answer = path.toArray(new String[0]);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], path, count + 1, tickets);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}