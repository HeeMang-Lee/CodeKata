import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long lo = 1;
        long hi = (long) times[times.length - 1] * n;
        
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long count = 0;
            for (int time : times) {
                count += mid / time ;
            }
            if (count >= n) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}