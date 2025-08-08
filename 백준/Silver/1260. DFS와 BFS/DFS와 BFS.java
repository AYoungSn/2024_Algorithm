import java.util.*;
import java.io.*;

public class Main {
	static int N, M, V;
	static List<Integer>[] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		for (int i =0; i < N + 1; i++) {
			Collections.sort(graph[i]);
		}
		System.out.print(V + " ");
		dfs(V, new boolean[N + 1]);
		System.out.println();
		bfs(V);
	}

	static void dfs(int v, boolean[] visited) {
		visited[v] = true;
		for (int next:graph[v]) {
			if (!visited[next]) {
				visited[next] = true;
				System.out.print(next + " ");
				dfs(next, visited);
			}
		}
	}

	static void bfs(int v) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> que = new LinkedList<>();
		que.add(v);
		while (!que.isEmpty()) {
			int cur = que.poll();
			if (visited[cur]) continue;
			visited[cur] = true;
			System.out.print(cur + " ");
			for (int next: graph[cur]) {
				if (!visited[next]) {
					que.add(next);
				}
			}
		}
	}

}
