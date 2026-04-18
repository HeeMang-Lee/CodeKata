import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() -2);
        String[] sets = s.split("\\},\\{");
        
        List<List<Integer>> list = new ArrayList<>();
        for (String set : sets) {
            List<Integer> nums = new ArrayList<>();
            for (String num : set.split(",")){
                nums.add(Integer.parseInt(num));
            }
            list.add(nums);
        }
        
        list.sort((a,b) -> a.size() - b.size());
        
        LinkedHashSet<Integer> lset = new LinkedHashSet<>();
        for (List<Integer> l : list) {
            lset.addAll(l);
        }
        return lset.stream().mapToInt(i -> i).toArray();
    }
}