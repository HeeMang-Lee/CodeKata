import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int N = board.length;
        int result = 0;
        for (int i = 0; i < moves.length ; i++) {
            for(int j = 0; j < N; j++) {
                if(board[j][moves[i]-1] != 0) { 
                    int doll = board[j][moves[i]-1];
                    board[j][moves[i]-1] = 0;
                    
                    if(!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        result += 2;
                    } else {
                        basket.push(doll);
                    }
                    break;
                }
            }
        }
        return result;
    }
}