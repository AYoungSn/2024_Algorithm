import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int[][] board;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		board = new int[N][N];
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				board[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				board[i][j] += board[i][j - 1];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				board[j][i] += board[j-1][i];
			}
		}
		for (int m = 0; m < M; m++) {
			inputs = br.readLine().split(" ");
			int x1 = Integer.parseInt(inputs[0]) - 1;
			int y1 = Integer.parseInt(inputs[1]) - 1;
			int x2 = Integer.parseInt(inputs[2]) - 1;
			int y2 = Integer.parseInt(inputs[3]) - 1;
			int ans = board[x2][y2];
			if (x1 > 0) ans -= board[x1 - 1][y2];
			if (y1 > 0) ans -= board[x2][y1 - 1];
			if (x1 > 0 && y1 > 0)
				ans += board[x1 - 1][y1 - 1];
			System.out.println(ans);
		}

	}
}
