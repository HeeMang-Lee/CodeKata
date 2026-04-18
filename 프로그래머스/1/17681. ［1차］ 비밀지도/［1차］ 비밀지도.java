class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            int combined = arr1[i] | arr2[i];
            String binary = Integer.toString(combined,2);
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            
            binary = binary.replace("1","#").replace("0"," ");
            answer[i] = binary;
        }
        return answer;
    }
}