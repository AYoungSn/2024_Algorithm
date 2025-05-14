import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] poja1 = new int[]{1,2,3,4,5};
        int[] poja2 = new int[]{2,1,2,3,2,4,2,5};
        int[] poja3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int[] cnt = new int[]{0,0,0};
        for (int i = 0; i < answers.length; i++) {
            if(poja1[i % poja1.length] == answers[i]) {
                cnt[0]++;
            }
            if(poja2[i % poja2.length] == answers[i]) {
                cnt[1]++;
            }
            if(poja3[i % poja3.length] == answers[i]) {
                cnt[2]++;
            }
        }
        int max = Math.max(cnt[2], Math.max(cnt[0], cnt[1]));
        int count = 0;
        for(int i= 0;i < 3;i++) {
            if (cnt[i]==max) {
                count ++;
            }
        }
        answer = new int[count];
        int a = 0;
        for(int i= 0;i < 3;i++) {
            if (cnt[i]==max) {
                answer[a++] = i + 1;
            }
        }
        return answer;
    }
}