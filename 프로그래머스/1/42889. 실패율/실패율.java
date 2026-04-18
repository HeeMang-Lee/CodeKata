import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int stop[] = new int[N+2];
        int reach[] = new int[N+2];
        
        for(int num : stages) {
            stop[num]++;
        }
        
        for (int i = 1; i <= N;  i++) {
            int cnt = 0;
            for(int num : stages) {
                if(num >= i) {
                    cnt++;
                }
            }
            reach[i] = cnt;
        }
        
        double[] failRate = new double[N+1];
        for (int i = 1; i <= N; i++) {
            if(reach[i] == 0) failRate[i] = 0.00;
            else failRate[i] = (double) stop[i] / reach[i] ;
        }
        
        Integer stageNum[] = new Integer[N];
        for(int i = 0 ; i < N; i++) {
            stageNum[i] = i+1;
        }
        
        Arrays.sort(stageNum, (a,b) -> {
            if(failRate[b] != failRate[a]) {
                return Double.compare(failRate[b],failRate[a]);
            }
            return a - b;
        });
        
        return Arrays.stream(stageNum).mapToInt(i -> i).toArray();
    }
}