class Solution {
    public int solution(int[] num_list) {
        int even = 0;
        int odd = 0;
        int len = num_list.length;
        for(int i = 0; i < len ; i++) {
            if(i % 2 == 0) {
                even += num_list[i];
            } 
            else if (i % 2 != 0) {
                odd += num_list[i];
            }
        }
        return even > odd ? even : odd;
    }
}