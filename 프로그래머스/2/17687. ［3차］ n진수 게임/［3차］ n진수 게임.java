import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() < m * t) {
            sb.append(Integer.toString(i, n).toUpperCase());
            i++;
        }
        StringBuilder answer = new StringBuilder();
        for (int k = 0 ; k < t; k++) {
            answer.append(sb.charAt(p-1 + m*k));
        }
        return answer.toString();
    }
}