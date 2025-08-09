import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int end;
		int weight;
		Node(int e, int w) {
			end = e;
			weight = w;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		List<Node>[] graph = new List[V + 1];
		int[] dist = new int[V + 1];

		for (int i = 0; i < V + 1; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}
		Queue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		que.add(new int[]{K, 0});
		dist[K] = 0;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (Node node : graph[cur[0]]) {
				if (dist[node.end] > cur[1] + node.weight) {
					dist[node.end] = cur[1] + node.weight;
					que.add(new int[]{node.end, dist[node.end]});
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(dist[i]);
		}
	}
}
