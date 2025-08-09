import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0 ; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String start= st.nextToken();
			String target = st.nextToken();
			boolean[] visited = new boolean[10001];
			Queue<Node> que = new LinkedList<>();
			que.add(new Node(start, ""));
			visited[Integer.parseInt(start)] = true;
			String answer = "";

			while(!que.isEmpty()) {
				Node cur = que.poll();
				if (cur.key.equals(target)) {
					sb.append(cur.cmd + "\n");
					break;
				}
				Integer d = (Integer.parseInt(cur.key) * 2) % 10000;
				if (!visited[d]) {
					que.add(new Node(d.toString(), cur.cmd + "D"));
					visited[d] = true;
				}
				Integer s = Integer.parseInt(cur.key) - 1;
				if (s.equals(-1)) {
					s = 9999;
				}
				if (!visited[s]) {
					que.add(new Node(s.toString(), cur.cmd + "S"));
					visited[s] = true;
				}
				Integer l = Integer.parseInt(cur.key);
				l = (l % 1000) * 10 + (l / 1000);
				if (!visited[l]) {
					que.add(new Node(l.toString(), cur.cmd + "L"));
					visited[l] = true;
				}
				Integer r = Integer.parseInt(cur.key);
				r = (r % 10) * 1000 + (r /10);
				if (!visited[r]) {
					que.add(new Node(r.toString(), cur.cmd + "R"));
					visited[r] = true;
				}
			}
		}
		System.out.println(sb);
	}
	static class Node {
		String key;
		String cmd;
		public Node(String key, String cmd) {
			this.key = key;
			this.cmd = cmd;
		}
	}
}
