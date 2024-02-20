import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static List<Node> arr;
	static int[] parent;

	static class Node {
		int start;
		int end;
		int weight;

		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];
		arr = new ArrayList<>();
		for (int i = 0; i < V + 1; i++) {
			parent[i] = i;
		}
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			arr.add(new Node(A, B, C));
		}
		Collections.sort(arr, (o1, o2) -> o1.weight - o2.weight);
		int i = 0;
		Long res = 0L;
		while (i < arr.size()) {
			Node cur = arr.get(i);
			int a = find(cur.start);
			int b = find(cur.end);
			if (a != b) {
				res += cur.weight;
				union(a, b);
			}
			i++;
		}
		System.out.println(res);
	}

	static int find(int c) {
		if (parent[c] == c) {
			return c;
		}
		return parent[c] = find(parent[c]);
	}

	static void union(int a, int b) {
		if (a != b) {
			parent[b] = a;
		}
	}
}
