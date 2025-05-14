import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
//         Arrays.sort(participant);
//         Arrays.sort(completion);
        
//         for (int i = 0; i < completion.length;i++) {
//             if (!participant[i].equals(completion[i])) {
//                 return participant[i];
//             }
//         }
        
//         return participant[participant.length - 1];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < completion.length;i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) + 1);
        }
        for (int i = 0; i < participant.length; i++) {
            if (map.getOrDefault(participant[i], 0) == 0) {
                return participant[i];
            }
            map.put(participant[i], map.getOrDefault(participant[i], 1) - 1);
        }
        return answer;
    }
}