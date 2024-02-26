import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] result;
	static int[][] group;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static Map<Integer, Integer> hmap = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		result = new int[N][M];
		group = new int[N][M];
		int index = 1;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (group[i][j] == 0 && map[i][j] == '0') {
					group[i][j] = index;
					hmap.put(index, bfs(map, i, j));
					index++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '1') {
					Set<Integer> set = new HashSet<>();
					result[i][j] = 1;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == '0' && group[nx][ny] != 0) {
							set.add(group[nx][ny]);
						}
					}
					for (int s : set) {
						result[i][j] += hmap.get(s);
						result[i][j] %= 10;
					}
				} else {
					result[i][j] = 0;
				}
				bw.append(result[i][j] + "");
			}
			bw.append('\n');
		}
		bw.flush();
	}
	static int bfs(char[][] map, int x, int y) {
		int cnt = 1;
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x, y});
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == '0' && group[nx][ny] == 0) {
					que.add(new int[] {nx, ny});
					group[nx][ny] = group[cur[0]][cur[1]];
					cnt++;
					cnt %= 10;
				}
			}
		}
		return cnt;
	}
}
