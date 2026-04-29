import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int priority = cur[0];
            int index = cur[1];
            boolean hasHigher = false;
            for (int[] p : q) {
                if (p[0] > cur[0]) {
                    hasHigher = true;
                    break;
                }
            }
            if (!hasHigher) {
                list.add(index);
            } else {
             q.offer(cur);
            }
        }
        int answer = list.indexOf(location) + 1;
        return answer;
    }
}