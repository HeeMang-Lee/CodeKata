import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scoreRank = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % 5]) {
                scoreRank[0]++;    
            } if (answers[i] == p2[i % 8]) {
                scoreRank[1]++;
            } if (answers[i] == p3[i % 10]) {
                scoreRank[2]++;
            }
        }
        int max = Math.max(scoreRank[0],Math.max(scoreRank[1],scoreRank[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        if(scoreRank[0] == max) list.add(1);
        if(scoreRank[1] == max) list.add(2);
        if(scoreRank[2] == max) list.add(3);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}