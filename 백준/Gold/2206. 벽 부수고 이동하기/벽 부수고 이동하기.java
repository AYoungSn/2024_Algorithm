import java.io.*;
import java.util.*;
public class Main {
	static String[] map;
	static int[][][] visited;
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new String[N];
		visited = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {0, 0, 0, 1});//x, y, crush, dist
		visited[0][0][0] = 1;
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			if (cur[0] == N - 1 && cur[1] == M - 1) {
				System.out.println(visited[N - 1][M - 1][cur[2]]);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur[0];
				int ny = dy[i] + cur[1];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny][cur[2]] == 0) {
					if (map[nx].charAt(ny) == '0') {
						visited[nx][ny][cur[2]] = cur[3] + 1;
						que.add(new int[] {nx, ny, cur[2], visited[nx][ny][cur[2]]});
					} else if (cur[2] == 0){
						visited[nx][ny][1] = cur[3] + 1;
						que.add(new int[] {nx, ny, 1, visited[nx][ny][1]});
					}
				}
			}
		}
		System.out.println(-1);
	}
}
