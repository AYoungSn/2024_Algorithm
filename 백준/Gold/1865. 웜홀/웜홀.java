import java.io.*;
import java.util.*;
public class Main {
	static class Node {
		int e;
		int w;

		Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < Tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			List<Node>[] graph = new List[N + 1];
			for (int i = 0; i < N + 1; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				graph[S].add(new Node(E, T));
				graph[E].add(new Node(S, T));
			}
			for (int w = 0; w < W; w++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = -Integer.parseInt(st.nextToken());
				graph[S].add(new Node(E, T));
			}
			boolean check = false;

			for (int i = 1; i <= N; i++) {
				if (bellmanford(i, N, graph)) {
					System.out.println("YES");
					check = true;
					break;
				}
			}
			if (!check){
				System.out.println("NO");
			}
		}

	}
	static int INF = 999999999;
	static boolean bellmanford(int start, int N, List<Node>[] graph) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean upd = false;
		for (int i = 0; i < N; i++) {// 정점의 수 - 1 만큼 반복
			upd = false;
			for (int j = 1; j < N + 1; j++) {
				for(Node node: graph[j]) {
					if (dist[j] != INF && dist[node.e] > dist[j] + node.w) {
						dist[node.e] = dist[j] + node.w;
						upd=true;
					}
				}
			}
			if (!upd) break;
		}
		return upd;
	}
}
