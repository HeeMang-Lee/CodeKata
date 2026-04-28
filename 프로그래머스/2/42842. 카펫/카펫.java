class Solution {
    public int[] solution(int brown, int yellow) {
        int row = 2;
        int col = 0;
        while(true) {
            row++;
            col = (brown + yellow) / row;
            if ((row - 2) * (col - 2) == yellow ) {
                break;
            }
        }
        if (col > row) {
            int temp = col;
            col = row;
            row = temp;
        }
        int[] answer = {row,col};
        return answer;
    }
}