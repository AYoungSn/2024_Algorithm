import java.util.*;
import java.io.*;
public class Main {
	static class Node implements Comparable<Node> {
		int e;
		int t;
		public Node(int e, int t){
			this.e = e;
			this.t = t;
		}
		public int compareTo(Node a) {
			return this.t - a.t;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		List<Node>[] graph = new List[N + 1];
		List<Node>[] graph2 = new List[N + 1];
		int[] dist = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
			graph2[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph[s].add(new Node(e, t));
			graph2[e].add(new Node(s, t));
		}
		int[] dist2 = new int[N + 1];
		bfs(X, dist, N, graph);
		bfs(X, dist2, N, graph2);
        dist[X] =0;
		dist2[X] = 0;
		int answer = dist[1] + dist2[1];
		for (int i = 1; i < N + 1; i++) {
			answer = Math.max(answer, dist[i] + dist2[i]);
		}
		System.out.println(answer);
	}

	static void bfs(int x, int[] dist, int N, List<Node>[] graph) {
		Queue<Node> que = new PriorityQueue<>();
		que.add(new Node(x, 0));
		boolean[] visited = new boolean[N + 1];
		visited[x] = true;
		dist[x] = 0;
		while (!que.isEmpty()) {
			Node cur = que.poll();
			for (Node n : graph[cur.e]) {
				if ((dist[n.e] == 0 || dist[cur.e] + n.t < dist[n.e])) {
					visited[n.e] = true;
					dist[n.e] = dist[cur.e] + n.t;
					que.add(new Node(n.e, dist[n.e]));
				}
			}
		}
	}
}
