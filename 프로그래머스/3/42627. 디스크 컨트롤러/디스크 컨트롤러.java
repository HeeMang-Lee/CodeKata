import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });
        int[][] req = new int[jobs.length][3];
        for (int i = 0; i < jobs.length; i++) {
            req[i][0] = jobs[i][0];
            req[i][1] = jobs[i][1];
            req[i][2] = i;
        }
        Arrays.sort(req, (a,b) -> a[0]-b[0]);
        int totalTime = 0;
        int curTime = 0;
        int jobIndex = 0;
        int compJob = 0;
        
        while (compJob < jobs.length) {
            while (jobIndex < jobs.length && req[jobIndex][0] <= curTime) {
                pq.add(req[jobIndex]);
                jobIndex++;
            }
            if(!pq.isEmpty()) {
                int[] curJob = pq.poll();
                curTime += curJob[1];
                totalTime += (curTime - curJob[0]);
                compJob++;
            } else {
                curTime = req[jobIndex][0];
            }
        }
        return totalTime/jobs.length;
    }
}