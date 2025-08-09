import java.util.*;
class Solution {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    public int solution(int[][] maps) {
        int answer = 0;
        Queue<int[]> que = new LinkedList();
        que.add(new int[]{0,0});
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for(int i =0 ; i < 4;i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
                    que.add(new int[]{nx, ny});
                }
            }
        }
        if (maps[maps.length - 1][maps[0].length - 1] == 1) {
            return -1;
        }
        return maps[maps.length - 1][maps[0].length - 1];
    }
}