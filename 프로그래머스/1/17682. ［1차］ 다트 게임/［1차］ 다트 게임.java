import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int idx = -1;
        int currentNumber = 0;
        
        for(int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if(Character.isDigit(c)) {
                currentNumber = currentNumber*10 + (c-'0');
            } else if (c == 'S' || c == 'D' || c == 'T'){
                idx++;
                int value = currentNumber;
                
                if (c == 'D') {
                    value *= value;
                } else if (c == 'T') {
                    value *= value*value;
                }
                score[idx] = value;
                currentNumber = 0;
            }
            else if(c == '*') {
                score[idx] *= 2;
                if(idx > 0) {
                    score[idx-1] *= 2;
                }
            }
            else if(c == '#') {
                score[idx] *= -1;
            }
        }
        
        return Arrays.stream(score).sum();
    }
}