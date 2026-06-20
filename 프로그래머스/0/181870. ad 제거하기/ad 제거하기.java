import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> list = new ArrayList<>();
        for (String arr : strArr) {
            if(!arr.contains("ad")) list.add(arr);
        }
        return list.toArray(new String[0]);
    }
}