import java.io.*;
import java.util.*;

public class Main {
	static int N,M, start, dest;
	static List<int[]>[] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new List[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int m = 0; m < M; m++) {
			String[] str = br.readLine().split(" ");
			graph[Integer.parseInt(str[0])].add(new int[] {Integer.parseInt(str[1]), Integer.parseInt(str[2])});
		}
		String[] str = br.readLine().split(" ");
		start = Integer.parseInt(str[0]);
		dest = Integer.parseInt(str[1]);
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[]{start, 0});
		int[] visited = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			visited[i] = Integer.MAX_VALUE;
		}
		visited[start] = 0;
		String[] paths = new String[N + 1];
		paths[start] = "" + start;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
            if (cur[0] == dest) {
				break;
			}
			for (int[] next : graph[cur[0]]) {
				if (visited[next[0]] > next[1] + cur[1] && next[0] != start) {
					visited[next[0]] = next[1] + cur[1];
					paths[next[0]] = paths[cur[0]] + " " + next[0];
					pq.add(new int[] {next[0], visited[next[0]]});
				}
			}
		}
		System.out.println(visited[dest]);
		System.out.println(paths[dest].split(" ").length);
		System.out.println(paths[dest]);
	}
}
