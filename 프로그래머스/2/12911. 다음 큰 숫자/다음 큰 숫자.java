class Solution {
    public int solution(int n) {
        int answer = n + 1;
        while (true) {
            if (Integer.bitCount(n) == Integer.bitCount(answer)) break;
            answer++;
        }
        return answer;
    }
}