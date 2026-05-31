import java.util.*;

class Solution {
    public String solution(String s) {
        String[] number = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < number.length; i++) {
            min = Math.min(Integer.parseInt(number[i]), min);
            max = Math.max(Integer.parseInt(number[i]), max);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}