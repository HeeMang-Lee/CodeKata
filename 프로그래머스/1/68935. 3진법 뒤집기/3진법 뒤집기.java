import java.util.*;

class Solution {
    public int solution(int n) {
    List<Integer> list1 = new ArrayList<Integer>();
        int answer = 0;
        while(n>0){
            list1.add(n % 3);
            n /= 3;
        }
        int size = list1.size();
        for(int i=0; i < size; i++) {
            answer += list1.get(i)*Math.pow(3, size - 1 - i);
        }
        return answer;
    }
}