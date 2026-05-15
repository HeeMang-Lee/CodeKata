class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int num : num_list) {
            answer += makeOne(num);
        }
        return answer;
    }
    
    public static int makeOne(int num) {
        int count = 0;
        while(num != 1) {
            if (num % 2 == 0) num /= 2;
            else if (num % 2 == 1) num = (num - 1) / 2;
            count++;
        }
        return count;
    }
}