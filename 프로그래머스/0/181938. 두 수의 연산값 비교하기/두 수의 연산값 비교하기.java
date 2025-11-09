class Solution {
    public int solution(int a, int b) {
        int digit = (int) Math.log10(b) + 1; 
        if(a * (int) Math.pow(10, digit) + b >= 2*a*b) {
            return a * (int) Math.pow(10, digit) + b;
        }else {
            return 2*a*b;
        }
    }
}