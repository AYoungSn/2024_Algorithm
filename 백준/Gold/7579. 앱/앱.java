import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());//확보할 메모리 크기
		// 활성화된 앱이 사용하는 메모리
		int[] active = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// 비활성화 비용
		int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// dp[i][j] : i번째 앱까지 고려하고, j비용으로 확보할 수 있는 최대 메모리
		int[][] dp = new int[N + 1][100 * 100 + 1];
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < 10001;j++) {
				if (i == 0) {
					if (j >= cost[i]) dp[i][j] = active[i];
				}
				else {
					if (j >= cost[i]) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + active[i]);
					else dp[i][j] = dp[i - 1][j];
				}
				if (dp[i][j] >= M) ans = Math.min(ans, j);
			}
		}
		System.out.println(ans);
	}
}