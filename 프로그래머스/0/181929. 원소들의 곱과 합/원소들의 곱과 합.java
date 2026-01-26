class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int square = 0;
        int len = num_list.length;
        int time = 1;
        for(int i = 0; i < len; i++) {
            sum += num_list[i];
            time *= num_list[i];
        }
        square += sum*sum;
        if (time < square) {
            return 1;
        }
        else {
            return 0;
        }
    }
}