import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for (int len : course) {
            Map<String,Integer> count = new HashMap<>();
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                combination(sorted, 0, len, new StringBuilder(), count);
            }
            int max = 0;
            for (int v : count.values()) max = Math.max(max,v);
            if (max < 2) continue;
            for (String key : count.keySet()) {
                if (count.get(key) == max) answer.add(key);
            }
        }
        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }
    
    public static void combination (String order, int start, int len, StringBuilder cur,Map<String,Integer> count) {
        if (cur.length() == len) {
            count.put(cur.toString(), count.getOrDefault(cur.toString(), 0) + 1);
            return;
        }
        for (int i = start; i < order.length(); i++) {
            cur.append(order.charAt(i));
            combination(order, i+1, len, cur, count);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}