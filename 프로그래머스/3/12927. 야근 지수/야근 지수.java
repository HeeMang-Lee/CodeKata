import java.util.PriorityQueue;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        while(n > 0 && !pq.isEmpty()) {
            int work = pq.poll();
            if (work == 0) break;
            if(work != 0) pq.offer(--work);
            n--;
        }
        long answer = 0;
        while(!pq.isEmpty()) {
            int rest = pq.poll();
            answer += rest*rest;
        }
        return answer;
    }
}