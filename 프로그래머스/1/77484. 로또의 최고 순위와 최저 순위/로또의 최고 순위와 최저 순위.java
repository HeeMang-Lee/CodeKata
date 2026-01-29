import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int match = 0;
        int unknown = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int lotto : lottos) {
            set.add(lotto);
            if(lotto == 0) {
                unknown++;
            }
        }
        for(int win_num : win_nums) {
            if(set.contains(win_num)) match++;
        }
    
        answer[1] = 7 - match;
        if(answer[1] > 6) answer[1] = 6;
        answer[0] = 7 - match - unknown;
        if(answer[0] > 6) answer[0] = 6;
        return answer;
    }
}