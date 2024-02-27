import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
		int[][] input = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		int res = 0;
		for (int i = 0; i < M; i++) {
			int a = findRoot(input[i][0]);
			int b = findRoot(input[i][1]);
			if (a != b) {
				union(a, b);
			} else {
				res = i + 1;
                break;
			}
		}
		System.out.println(res);
	}

	static int findRoot(int a) {
		if (parent[a] == a) {
			return parent[a];
		}
		return parent[a] = findRoot(parent[a]);
	}

	static void union(int a, int b) {
		if (a != b) {
			parent[b] = a;
		}
	}
}
