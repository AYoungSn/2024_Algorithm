import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int init = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{target, 1});
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			if (cur[0] % 2 == 0) {
				que.add(new int[]{cur[0] / 2, cur[1] + 1});
			}
			if (cur[0] % 10 == 1) {
				que.add(new int[]{cur[0] / 10, cur[1] + 1});
			}
			if (cur[0] == init) {
				System.out.println(cur[1]);
				return;
			}
			if (cur[0] % 2 != 0 && cur[0] % 10 != 1 || cur[0] < init) {
				System.out.println(-1);
				break;
			}
		}
	}
}
