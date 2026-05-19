class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1, end = 1;
        int sum = 1;
        while (start <= n) {
            if (sum == n) {
                answer++;
                end++;
                sum += end;
            }
            else if (sum < n) {
                end++;
                sum += end;
            }
            else {
                sum -= start;
                start++;
            }
        }
        return answer;
    }
}