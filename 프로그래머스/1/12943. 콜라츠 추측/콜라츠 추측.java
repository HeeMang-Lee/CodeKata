class Solution {
    public int solution(long num) {
        int t = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            t++;

            if (t == 500) {
                return -1;
            }
        }

        return t; 
    }
}