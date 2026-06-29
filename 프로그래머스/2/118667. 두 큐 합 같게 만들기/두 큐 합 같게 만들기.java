class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        int[] queue = new int[len * 2];
        long sum1 = 0 , sum2 = 0;
        for (int num : queue1) {
            sum1 += num;
        }
        for (int num : queue2) {
            sum2 += num;
        }
        if ((sum1 + sum2) % 2 != 0) return -1;
        long target = (sum1 + sum2) / 2;
        
        for (int i = 0; i < len; i++) {
            queue[i] = queue1[i];
            queue[i + len] = queue2[i];
        }
        int start = 0;
        int end = len;
        int count = 0;
        long curSum = sum1;
        int limit = 4 * len;
        
        while (count <= limit) {
            if (curSum == target) return count;
            
            if (curSum < target) {
                if (end >= queue.length) return -1;
                curSum += queue[end];
                end++;
            } else {
                curSum -= queue[start];
                start++;
            }
            count++;
         }
        
        return -1;
    }
}