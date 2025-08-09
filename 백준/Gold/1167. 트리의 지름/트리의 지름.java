
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		List<Node>[] tree = new List[V + 1];
		for (int v = 0; v < V; v++) {
			String[] inputs = br.readLine().split(" ");
			int s = Integer.parseInt(inputs[0]);
			tree[s] = new ArrayList<>();
			for (int i = 1; i < inputs.length - 1; i+=2) {
				int e = Integer.parseInt(inputs[i]);
				int w = Integer.parseInt(inputs[i + 1]);
				tree[s].add(new Node(s, e, w));
			}
		}
		boolean[] visited = new boolean[V + 1];
		int[] dist = new int[V + 1];
		Queue<Integer> que = new LinkedList<>();
		visited[1] = true;
		que.add(1);
		while (!que.isEmpty()) {
			int cur = que.poll();
			for (Node tr : tree[cur]) {
				if (!visited[tr.next] && (dist[tr.next] == 0 || dist[cur] + tr.weight > dist[tr.next])) {
					dist[tr.next] = dist[cur] + tr.weight;
					visited[tr.next] = true;
					que.add(tr.next);
				}
			}
		}
		int target = dist[0];
		int tgidx = 0;
		for (int i = 0; i < V + 1; i++) {
			if (target < dist[i]) {
				target = dist[i];
				tgidx = i;
			}
		}
		visited = new boolean[V + 1];
		dist = new int[V + 1];
		que = new LinkedList<>();
		visited[tgidx] = true;
		que.add(tgidx);
		while (!que.isEmpty()) {
			int cur = que.poll();
			for (Node tr : tree[cur]) {
				if (!visited[tr.next] && (dist[tr.next] == 0 || dist[cur] + tr.weight > dist[tr.next])) {
					dist[tr.next] =  dist[tr.cur] + tr.weight;
					visited[tr.next] = true;
					que.add(tr.next);
				}
			}
		}
		target = dist[1];
		for (int i = 1; i < V; i++) {
			target = Math.max(target, dist[i + 1]);
		}
		System.out.println(target);
	}
	static class Node {
		int cur;
		int next;
		int weight;
		public Node(int cur, int next, int weight) {
			this.cur = cur;
			this.next = next;
			this.weight = weight;
		}
	}
}
