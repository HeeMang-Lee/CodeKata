import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        HashSet<String> reportSet = new HashSet<>();
        HashMap<String,Integer> reportedCount = new HashMap<>();
        HashMap<String,HashSet<String>> reportedBy = new HashMap<>();
        int[] result = new int[id_list.length];

        for(String report : reports) {
            reportSet.add(report);
        }
        // 신고한 사람과 신고당한 사람을 각각에 map에 추가하기
        for (String rep : reportSet) {
            String[] parts = rep.split(" ");
            String reporter = parts[0];
            String target = parts[1];
        
            reportedCount.put(target, reportedCount.getOrDefault(target,0) + 1);
            
            if(!reportedBy.containsKey(target)) {
                reportedBy.put(target, new HashSet<>());
            }
            reportedBy.get(target).add(reporter);
        }
        for(String target : reportedCount.keySet()) {
            if(reportedCount.get(target) >= k) {
                for(int i  = 0; i < id_list.length; i++) {
                    if(reportedBy.get(target).contains(id_list[i])) result[i]++;
                }
            }
        }
        return result;
    }
}