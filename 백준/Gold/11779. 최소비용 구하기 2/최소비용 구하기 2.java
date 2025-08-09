import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<int[]>[] graph = new List[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s].add(new int[] {e, w});
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Queue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		que.add(new int[] {S, 0});
		String[] paths = new String[n + 1];
		paths[S] = "" + S;
		int[] dist = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[S] = 0;
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			if (cur[0] == E) {
				break;
			}
			for (int[] node : graph[cur[0]]) {
				if (node[0] != S && dist[node[0]] > cur[1] + node[1]) {
					dist[node[0]] = cur[1] + node[1];
					paths[node[0]] = paths[cur[0]] + " " + node[0];
					que.add(new int[] {node[0], dist[node[0]]});
				}
			}
		}
		dist[S] =0;
		System.out.println(dist[E]);
		System.out.println(paths[E].split(" ").length);
		System.out.println(paths[E]);
	}
}
