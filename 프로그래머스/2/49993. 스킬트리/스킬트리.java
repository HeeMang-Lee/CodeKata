import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String tree : skill_trees) {
            if(check(skill,tree)) answer++;
        }
        return answer;
    }
    
    public static boolean check (String skill, String tree) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < skill.length(); i++) {
            q.offer(skill.charAt(i));
        }
        for (int i = 0; i < tree.length(); i++) {
            char c = tree.charAt(i);
            if(q.contains(c)) {
                if(q.poll() != c) return false;
            }
        }
        return true;
    }
}