import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> temparr = new ArrayList<>();
        
        for(int i:arr){
            if(i%divisor == 0){
                temparr.add(i);
            }
        }
        
        if(temparr.isEmpty()){
            return new int[]{-1};
        }
        
        int[] answer = temparr.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}