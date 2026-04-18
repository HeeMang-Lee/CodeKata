import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String[] digits = String.valueOf(n).split("");
        Arrays.sort(digits, Collections.reverseOrder());
        return Long.parseLong(String.join("",digits));
    }
}