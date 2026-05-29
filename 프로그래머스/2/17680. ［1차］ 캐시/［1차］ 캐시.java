import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        LinkedList<String> cache = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer++;
            }
            else {
                if (cache.size() == cacheSize) cache.remove();
                cache.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}