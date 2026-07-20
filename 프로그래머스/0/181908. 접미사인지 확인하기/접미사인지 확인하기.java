import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        if (is_suffix.length() > my_string.length()) return 0;
        StringBuilder sb = new StringBuilder();
        for (int i = is_suffix.length(); i > 0; i--) {
            sb.append(my_string.charAt(my_string.length() - i));
        }
        if(sb.toString().equals(is_suffix)) return 1;
        return 0;
    }
}