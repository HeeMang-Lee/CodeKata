import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Character, Integer> mapX = new HashMap<>();
        HashMap<Character, Integer> mapY = new HashMap<>();

        for (char x : X.toCharArray()) {
            mapX.put(x, mapX.getOrDefault(x, 0) + 1);
        }
        for (char y : Y.toCharArray()) {
            mapY.put(y, mapY.getOrDefault(y, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            char c = (char) (i + '0');
            int count = Math.min(mapX.getOrDefault(c, 0), mapY.getOrDefault(c, 0));
            for (int j = 0; j < count; j++) {
                sb.append(c);
            }
        }
        String answer = sb.toString();
        if(answer.equals("")) answer = "-1";
        if(answer.charAt(0) == '0') answer = "0";
        return answer;
    }
}