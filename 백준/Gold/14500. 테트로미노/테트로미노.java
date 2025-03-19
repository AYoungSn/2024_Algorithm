import java.util.*;
import java.io.*;

public class Main {
    static int result, N, M;
    static boolean[][] visited;
    static int[][] board;

    public static void dfs(int r, int c, int n, int res) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        if (n == 4) {
            result = Math.max(res, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + r;
            int ny = dy[i] + c;
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                if (n == 2) {
                    visited[nx][ny] = true;
                    dfs(r, c, n + 1, res + board[nx][ny]);
                    visited[nx][ny] = false;
                }
                visited[nx][ny] = true;
                dfs(nx, ny, n + 1, res + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(result);
    }
}