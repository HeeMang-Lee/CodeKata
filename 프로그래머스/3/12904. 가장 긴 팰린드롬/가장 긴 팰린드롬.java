class Solution {
    public int solution(String s) {
        int maxLen = 1;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            
            maxLen = Math.max(maxLen, Math.max(len1, len2));
        }
        return maxLen;
    }
    
    // 중심에서 양쪽으로 확장하며 팰린드롬 길이 반환
    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() 
               && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}