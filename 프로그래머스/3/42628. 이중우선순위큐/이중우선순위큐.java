import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < operations.length; i++) {
            String[] parts = operations[i].split(" ");
            String cmd = parts[0];
            int num = Integer.parseInt(parts[1]);
            
            if (cmd.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                continue;
            }
            
            if (cmd.equals("D")) {
                if (map.isEmpty()) continue;
                if (num == 1) {
                    int key = map.lastKey();
                    if (map.get(key) == 1) map.remove(key);
                    else map.put(key, map.get(key) - 1);
                }
                if (num == -1) {
                    int key = map.firstKey();
                    if (map.get(key) == 1) map.remove(key);
                    else map.put(key, map.get(key) - 1);
                }
            }
        }
        
        if (map.isEmpty()) return new int[]{0,0};
        else return new int[]{map.lastKey(),map.firstKey()};
    }
}