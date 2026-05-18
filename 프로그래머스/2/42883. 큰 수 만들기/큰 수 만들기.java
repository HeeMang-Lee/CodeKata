import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int len = number.length();

        for (int i = 0; i < len; i++) {
            char c  = number.charAt(i);
            
            while(!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (char character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}