class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            answer = lcm(answer,arr[i]);
        }
        return answer;
    }
    
    public static int gcd (int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
    
    public static int lcm (int a, int b) {
        return (a * b) / gcd(a,b);
    }
}