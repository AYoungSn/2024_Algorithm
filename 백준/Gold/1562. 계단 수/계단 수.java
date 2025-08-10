import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][][] dp = new long[N + 1][10][1<<10];//[자리수][끝자리수][bit]
		for (int i = 1; i < 10; i++) {
			dp[1][i][1<<i] = 1;
		}
		for (int i = 2; i < N + 1; i++) {//자리수
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 1024; k++) {
					int bit = k | (1 << j);
					if (j == 0)
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k]) % 1_000_000_000;
					else if (j == 9) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k]) % 1_000_000_000;
					} else
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % 1_000_000_000;
				}
			}
		}
		long ans = 0;
		for (int i = 0; i < 10; i++) {
			ans= (ans + dp[N][i][1023]) % 1_000_000_000;
		}
		System.out.println(ans);
	}
}
