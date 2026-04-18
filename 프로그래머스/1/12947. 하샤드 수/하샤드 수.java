class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int[] digits = Integer.toString(x).chars().map(c-> c-'0').toArray();
        int sum = 0;
        for(int num:digits){
            sum += num;
        }
        if(x % sum != 0){
            answer = false;
        }
        return answer;
    }
}