class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length ; i++){
            sb.append(String.valueOf(i).repeat(food[i]/2));
        }
        StringBuilder answer = new StringBuilder(sb);
        answer.append(0);
        answer.append(sb.reverse());

        return answer.toString();
    }
}