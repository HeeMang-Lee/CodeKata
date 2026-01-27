import java.util.ArrayList;

class Solution {
    public int[] solution(String myString) {
        int start = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                list.add(i - start);
                start = i + 1;
            }
        }
        list.add(myString.length() - start);
        return list.stream().mapToInt(i -> i).toArray();
    }
}