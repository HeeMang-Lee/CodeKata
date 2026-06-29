class Solution {
    static int max = 0;
    static int[] bestRyan = new int[11];
    
    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        dfs(0, info, n, ryan);
        if (max == 0) return new int[]{-1};
        return bestRyan;
    }
    
    public void dfs(int idx, int[] info, int remain, int[] ryan) {
        
        if (idx == 10) {
            ryan[10] = remain;
            int sumRyan = 0, sumApeach = 0;
            for (int i = 0; i <= 10; i++) {
                int point = 10 - i;
                if (ryan[i] == 0 && info[i] == 0) continue;
                if (ryan[i] > info[i]) sumRyan += point;
                else sumApeach += point;
            }
            int diff = sumRyan - sumApeach;
            if (diff > max) {
                max = diff;
                bestRyan = ryan.clone();
            } else if (diff == max && diff > 0) {
                for (int i = 10; i >= 0; i--) {
                    if (ryan[i] > bestRyan[i]) {
                        bestRyan = ryan.clone();
                        break;
                    }
                    if (ryan[i] < bestRyan[i]) break;
                }
            }
            ryan[10] = 0;   
            return;
        }
        
        for (int shots = 0; shots <= remain; shots++) {
            ryan[idx] = shots;
            dfs(idx + 1, info, remain - shots, ryan);
            ryan[idx] = 0;
        }
    }
}