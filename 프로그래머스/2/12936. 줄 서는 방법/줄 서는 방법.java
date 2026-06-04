import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) candidates.add(i);
        k--;
        
        for (int i = 0; i < n; i++) {
            long fact = factorial(n-1-i);
            int idx = (int)(k/fact);
            answer[i] = candidates.get(idx);
            candidates.remove(idx);
            k = k % fact;
        }
        return answer;
    }
    public static long factorial(int number) {
        long answer = 1;
        for (int i = 1; i <= number; i++) {
            answer *= i;
        }
        return answer;
    }
}