import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        int len = files.length;
        String[] heads = new String[len];
        int[] numbers = new int[len];
        Integer[] indeces = new Integer[len];
        
        for(int i = 0; i < len; i++) {
            String file = files[i];
            int j = 0;
            while (j < file.length() && !Character.isDigit(file.charAt(j))) j++;
            heads[i] = file.substring(0,j).toLowerCase();
            int k = j;
            while (k < file.length() && Character.isDigit(file.charAt(k)) && k - j < 5) k++;
            numbers[i] = Integer.parseInt(file.substring(j,k));
        }
        
        for (int i = 0; i < len; i++) indeces[i] = i;
        Arrays.sort(indeces, (a,b) -> {
            if(!heads[a].equals(heads[b])) return heads[a].compareTo(heads[b]);
            return numbers[a] - numbers[b];
        });
        
        String[] answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = files[indeces[i]];
        }
        return answer;
    }
}