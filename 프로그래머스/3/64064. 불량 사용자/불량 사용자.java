import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        Set<String> selected =  new HashSet<>();
        Set<Set<String>> result = new HashSet<>();
        dfs(0,selected,result,banned_id,user_id);
        return result.size();
    }
    public static void dfs(int cur_index,Set<String> selected, Set<Set<String>> result,
                           String[] banned_id, String[] user_id) {
        if(cur_index == banned_id.length) {
            result.add(new HashSet<>(selected));
            return;
        }
        for (String user : user_id) {
            if (selected.contains(user)) continue;
            if (!matched(user, banned_id[cur_index])) continue;
            selected.add(user);
            dfs(cur_index + 1, selected, result, banned_id, user_id);
            selected.remove(user);
        }
    }
    
    public static boolean matched (String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < banned.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (banned.charAt(i) != user.charAt(i)) return false;
        }
        return true;
    }
}