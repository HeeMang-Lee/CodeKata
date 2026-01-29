import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character,Integer> map = new HashMap<>();
        for (String key : keymap) {
           for (int i = 0; i < key.length(); i++) {
               char c = key.charAt(i);
               int press = i + 1;
               
               map.put(c, Math.min(map.getOrDefault(c,100), press));
           } 
        }
        
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                if(map.containsKey(targets[i].charAt(j))) {
                    answer[i] += map.get(targets[i].charAt(j));
                } else {
                    answer [i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}