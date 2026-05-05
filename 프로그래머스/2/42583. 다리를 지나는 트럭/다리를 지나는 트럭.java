import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        int cur = 0;
        int time = 0;
        Queue<Integer> truck = new LinkedList<>();
        for (int i : truck_weights) {
            truck.offer(i);
        }
        while(!truck.isEmpty()) {
            time ++;
            cur -= bridge.poll();
            
            if (cur + truck.peek() <= weight) {
                cur += truck.peek();
                bridge.offer(truck.poll());
            }
            else {
                bridge.offer(0);
            }
        }
        return time + bridge_length;
    }
}