import java.util.*;
class Solution {
    public int solution(String name) {
        int upDown = 0;
        for (int i = 0; i < name.length(); i++) {
            upDown += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
        }   
        int leftRight = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            leftRight = Math.min(leftRight, i*2 + (name.length() - next));
            leftRight = Math.min(leftRight, (name.length() - next)*2 + i);
        }
        return upDown + leftRight;
    }
}