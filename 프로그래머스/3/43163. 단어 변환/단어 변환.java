import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];  
        return bfs (visited, begin, target, words);
    }    
    
    public static boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++)  {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
    
    public static int bfs (boolean[] visited, String begin, String target, String[] words) { 
        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[]{begin, "0"});
        while(!q.isEmpty()) {
            String[] cur = q.poll();
            String word = cur[0];
            int depth = Integer.parseInt(cur[1]);
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(word, words[i])) {
                    visited[i] = true;
                    q.offer(new String[]{words[i], String.valueOf(depth + 1)});
                    if (words[i].equals(target)) return ++depth;
                }
            }
        }
        return 0;
    }
}