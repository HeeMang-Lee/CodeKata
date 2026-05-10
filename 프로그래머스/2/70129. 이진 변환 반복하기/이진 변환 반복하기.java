import java.util.*;

class Solution {
    public int[] solution(String s) {
        int countTransform = 0;
        int countZero = 0;
        
        while (!s.equals("1")) {
            int originLen = s.length();
            String removeZero = s.replaceAll("0","");
            int afterLen = removeZero.length();
            countZero += (originLen - afterLen);
            s = Integer.toBinaryString(afterLen);
            countTransform++;
        }
        return new int[]{countTransform, countZero};
    }
}