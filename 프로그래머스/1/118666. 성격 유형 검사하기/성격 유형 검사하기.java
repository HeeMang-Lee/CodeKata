import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for (int i = 0; i < survey.length; i++) {
            char left = survey[i].charAt(0);   
            char right = survey[i].charAt(1);  
    
            if (choices[i] == 1) map.put(left, map.getOrDefault(left, 0) + 3);
            if (choices[i] == 2) map.put(left, map.getOrDefault(left, 0) + 2);
            if (choices[i] == 3) map.put(left, map.getOrDefault(left, 0) + 1);
            if (choices[i] == 5) map.put(right, map.getOrDefault(right, 0) + 1);
            if (choices[i] == 6) map.put(right, map.getOrDefault(right, 0) + 2);
            if (choices[i] == 7) map.put(right, map.getOrDefault(right, 0) + 3);
}
        
        String answer = "";
        if (map.getOrDefault('R',0) >= map.getOrDefault('T',0)) answer += 'R';
        else answer += 'T';
        if (map.getOrDefault('C',0) >= map.getOrDefault('F',0)) answer += 'C';
        else answer += 'F';
        if (map.getOrDefault('J',0) >= map.getOrDefault('M',0)) answer += 'J';
        else answer += 'M';
        if (map.getOrDefault('A',0) >= map.getOrDefault('N',0)) answer += 'A';
        else answer += 'N';
        return answer;
    }
}