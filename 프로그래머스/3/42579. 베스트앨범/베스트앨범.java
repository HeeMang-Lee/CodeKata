import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> genreTotalMap = new HashMap<>();
        HashMap<String, List<int[]>> songs = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            genreTotalMap.put(genres[i],genreTotalMap.getOrDefault(genres[i], 0) + plays[i]);
            songs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }
        List<String> sortedGenres = new ArrayList<>(genreTotalMap.keySet());
        sortedGenres.sort((a,b) -> genreTotalMap.get(b) - genreTotalMap.get(a));
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> list = songs.get(genre);
            list.sort((a,b) -> {
                if(a[1] != b[1]) return b[1] - a[1];
                return a[0] - b[0];
            });
            
            for (int i = 0; i < Math.min(list.size(),2); i++) {
                result.add(list.get(i)[0]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}