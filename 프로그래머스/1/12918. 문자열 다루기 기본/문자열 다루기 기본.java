class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() !=4 && s.length() !=6){
            answer = false;
        }
        try {
    	  Integer.parseInt(s);
      } catch (NumberFormatException e) {
    	 answer = false;
      }
        return answer;
    }
}