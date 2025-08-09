import java.util.*;
class Solution {
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    void bfs(int x, boolean[] visited, int[][] computers, int n) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        while(!que.isEmpty()) {
            int cur = que.poll();
            for(int i = 0; i < n; i++) {
                if (computers[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0;i< n;i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                bfs(i, visited, computers, n);
            }
        }
        return answer;
    }
}