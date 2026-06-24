import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String result = "(None)";
        int maxPlayTime = -1;
        
        for(String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            String startTime = info[0];
            String endTime = info[1];
            String songName = info[2];
            String melody = info[3];
            
            String[] startTokens = startTime.split(":");
            int startMin = Integer.parseInt(startTokens[0]) * 60 + Integer.parseInt(startTokens[1]);
            
            String[] endTokens = endTime.split(":");
            int endMin = Integer.parseInt(endTokens[0]) * 60 + Integer.parseInt(endTokens[1]);
            
            int playTime = endMin - startMin;
            StringBuilder sb = new StringBuilder();
            String parseMelody = changeMelody(melody);
            int replay = playTime / parseMelody.length();
            int rest = playTime % parseMelody.length();
            for (int i = 0; i < replay; i++) {
                sb.append(parseMelody);
            }
            for (int i = 0; i < rest; i++) {
                sb.append(parseMelody.charAt(i));
            }
            String fullMelody = sb.toString();
            if (fullMelody.contains(changeMelody(m))) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    result = songName;
                }
            }
        }
        return result;
    }
    
    public String changeMelody(String melody) {
        return melody.replaceAll("C#", "c")
            .replaceAll("D#","d")
            .replaceAll("F#","f")
            .replaceAll("G#","g")
            .replaceAll("A#","a");
    }
}