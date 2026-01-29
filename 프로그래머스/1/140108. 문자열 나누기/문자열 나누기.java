class Solution {
    public int solution(String s) {
        int result = 0;
        
        while(s.length() > 0) {
            char start = s.charAt(0);
            int x = 0;
            int other = 0;
            int cutIndex = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == start) x++;
                else other++;
            

                if (x == other) {
                    cutIndex = i+1;
                    break;
                }
            }
            if (x != other) {
                cutIndex = s.length();
            }
            
            s = s.substring(cutIndex);
            result++;
        }
        return result;
    }
}