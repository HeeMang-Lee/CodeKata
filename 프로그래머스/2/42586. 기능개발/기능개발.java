import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = speeds.length;
        int[] rest = new int[len];
        for(int i = 0; i < len; i++) {
            double d = (double) (100-progresses[i])/speeds[i];
            int result = (int) Math.ceil(d);
            rest[i] = result;
        }
            
      List<Integer> answer = new ArrayList<>();
      int maxDay = rest[0];
        int count = 1;
      
      for (int i = 1; i < len ; i++) {
          if (rest[i] <= maxDay) {
              count++;
         } else {
             answer.add(count);
             count = 1;
              maxDay = rest[i];
          }
      }
    answer.add(count);
    
    return answer.stream().mapToInt(i -> i).toArray();
    }
}