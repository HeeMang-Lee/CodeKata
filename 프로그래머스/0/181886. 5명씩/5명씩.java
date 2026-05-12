import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        String[] answer = new String[(names.length + 4) / 5];
        answer[0] = names[0];
        if (names.length > 4)
        {   
            for (int i = 5; i < names.length; i += 5) {
                answer[i/5] = names[i];  
            }
        }
        return answer;
    }
}