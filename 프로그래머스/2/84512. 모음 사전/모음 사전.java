import java.util.*;

class Solution {
    public int solution(String word) {
        char[] vowels = {'A','E','I','O','U'};
        dfs("",vowels,word);
        return count;
    }
    
    static int count = -1;
    static boolean found = false;   
    
    public static void dfs(String current,char[] vowels,String word) {
        if (current.length() > 5) return;
        count++;
        
        if (current.equals(word)) {
            found = true;
            return;
        }
        for (char v : vowels) {
            if (!found) dfs(current + v , vowels, word);
        }
    }
}