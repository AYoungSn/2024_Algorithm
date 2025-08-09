
import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//person
		int M = Integer.parseInt(st.nextToken());//party
		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		if (cnt == 0) {
			System.out.println(M);
			return;
		}
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
		boolean[] knows = new boolean[N + 1];
		for (int i = 0; i < cnt; i++) {
			int a = Integer.parseInt(st.nextToken());
			knows[a] = true;
		}
		List<Integer>[] parties = new List[M];
		String[] inputs;
		for (int i = 0; i < M; i++) {
			parties[i] = new ArrayList<>();
			inputs = br.readLine().split(" ");
			int num = Integer.parseInt(inputs[0]);
			if (num > 0) {
				parties[i].add(Integer.parseInt(inputs[1]));
			}
			for (int j = 1; j < num; j++) {
				int a = Integer.parseInt(inputs[j]);
				int b = Integer.parseInt(inputs[j + 1]);
				union(a, b);
				parties[i].add(b);
			}
		}
		// 진실을 아는 사람과 같은 파티 참석한 경우 아는 사람으로 체크
		for (int i = 1; i < N + 1; i++) {
			if (knows[i]) {
				int root = find(i);
				for (int j = 1; j < N + 1; j++) {
					if (root == find(j)) {
						knows[j] = true;
					}
				}
			}
		}
		int answer = M;
		for (int m = 0; m < M; m++) {
			for (int p: parties[m]) {
				if (knows[p]) {
					answer--;
					break;
				}
			}
		}
		System.out.println(answer);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (a <= b) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}
	}
	static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return find(parent[a]);
	}
}
