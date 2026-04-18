import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int leftHand = 10, rightHand = 12;  
        
        for (int number : numbers) {
            if (number == 0) number = 11;  
            
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                leftHand = number;
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                rightHand = number;
            } else {
                int leftDist = getDistance(leftHand, number);
                int rightDist = getDistance(rightHand, number);
                
                if (leftDist < rightDist) {
                    sb.append("L");
                    leftHand = number;
                } else if (rightDist < leftDist) {
                    sb.append("R");
                    rightHand = number;
                } else {
                    
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftHand = number;
                    } else {
                        sb.append("R");
                        rightHand = number;
                    }
                }
            }
        }
        return sb.toString();
    }
    
    int getDistance(int from, int to) {
        int r1 = (from - 1) / 3, c1 = (from - 1) % 3;
        int r2 = (to - 1) / 3, c2 = (to - 1) % 3;
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}