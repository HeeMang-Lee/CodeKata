import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        
        for (int i : arr) {
            set.add(i);
        }
        
        int[] dedup = set.stream().mapToInt(i -> i).toArray();
        int[] answer= new int[k];
        Arrays.fill(answer, -1);
        
        for(int i = 0; i < k && i < dedup.length; i++) {
            answer[i] = dedup[i];
        }
        return answer;
    }
}