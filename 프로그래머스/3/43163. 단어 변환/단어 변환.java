import java.util.*;
class Solution {
    class Node {
        String str;
        int cnt;
        Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
        while(!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.str.equals(target)) {
                return cur.cnt;
            }
            for(int i = 0; i < words.length; i++) {
                if (!visited[i]){
                    int cnt = 0;
                    for(int j = 0; j < words[i].length(); j++) {
                        if (cur.str.charAt(j) != words[i].charAt(j)) {
                            cnt++;
                        }
                        if (cnt > 1) break;
                    }
                    if (cnt == 1) {
                        que.add(new Node(words[i], cur.cnt + 1));
                        visited[i] = true;
                    }
                }
            }
        }
        return answer;
    }
}