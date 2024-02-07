import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] path;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		path = new int[100001];
		Arrays.fill(path, Integer.MAX_VALUE);
		path[N] = 0;
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		while (!que.isEmpty()) {
			Integer cur = que.poll();
			if (cur == K && path[K] < min) {
				min = path[K];
				cnt = 1;
				continue;
			} else if (cur == K && path[K] != Integer.MAX_VALUE && path[K] == min) {
				cnt++;
				continue;
			}
			if (cur + 1 <= 100000 && path[cur + 1] >= path[cur] + 1) {
				path[cur + 1] = path[cur] + 1;
				que.add(cur + 1);
			}
			if (cur - 1 >= 0 && path[cur - 1] >= path[cur] + 1) {
				path[cur - 1] = path[cur] + 1;
				que.add(cur - 1);
			}
			if (cur * 2 <= 100000 && path[cur * 2] >= path[cur] + 1) {
				path[cur * 2] = path[cur] + 1;
				que.add(cur * 2);
			}

		}
		System.out.println(path[K]);
		System.out.println(cnt);
	}
}
