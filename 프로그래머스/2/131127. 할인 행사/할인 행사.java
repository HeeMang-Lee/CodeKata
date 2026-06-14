import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0; i <= discount.length - 10; i++) {
            HashMap<String,Integer> map = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                map.put(discount[j],map.getOrDefault(discount[j],0) + 1);
            }
            if (matched(want,number,map)) answer++;
        }
        return answer;
    }
    public static boolean matched (String[] want, int[] number, HashMap<String,Integer> map) {
        for (int k = 0; k < want.length; k++) {
            if (map.getOrDefault(want[k], 0) != number[k]) return false;
        }
        return true;
    }
}