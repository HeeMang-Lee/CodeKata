import java.util.*;

class Solution {
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited);
        return set.size();
    }
    static Set<Integer> set = new HashSet<>();
    
    public static void dfs(String current, String numbers,boolean[] visited) {
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) set.add(num);
    }
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }
        
    public static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) return false;
    }
    return true;
    }
}