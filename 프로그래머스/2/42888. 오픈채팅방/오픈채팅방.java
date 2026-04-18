import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        HashMap<String,String> map = new HashMap<>();
        for(String record : records) {
            String[] parts = record.split(" ");
             if (parts[0].equals("Enter") || parts[0].equals("Change")) {
                map.put(parts[1], parts[2]);
            }
        }
        List<String> result = new ArrayList<>();
        
        for(String record : records) {
            String[] parts = record.split(" ");
            if (record.startsWith("Enter")) {
            result.add(map.get(parts[1])+"님이 들어왔습니다.") ;
            }
            else if (record.startsWith("Leave")) {
            result.add(map.get(parts[1])+"님이 나갔습니다.") ;
            }
        }
        return result.toArray(new String[0]);
    }
}