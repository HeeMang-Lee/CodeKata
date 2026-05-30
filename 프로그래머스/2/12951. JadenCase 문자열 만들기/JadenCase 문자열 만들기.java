class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sentences = s.split(" ", -1);
        for (String sentence : sentences) {
            if (sentence.isEmpty()) {
                sb.append(" ");
                continue;
            }
            char first = Character.toUpperCase(sentence.charAt(0));
            sb.append(first);
            for (int i = 1; i < sentence.length(); i++) {
                char c = Character.toLowerCase(sentence.charAt(i));
                sb.append(c);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }
}