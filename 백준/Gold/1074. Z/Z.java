import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		Long ans = 0L;
		while (N > 0) {
			N -= 1;
			// 1사분면
			if (R < (1 << N) && C < (1 << N)) {
				ans = ans;
			} else if (R < (1 << N) && C >= (1 << N)) {
				ans += (1 << N) * (1 << N);
				C -= 1 << N;
			} else if (R >= (1 << N) && C < (1 << N)) {
				ans += (1 << N) * (1 << N) * 2;
				R -= 1 << N;
			} else if (R >= (1 << N) && C >= (1 << N)){
				ans += (1 << N) * (1 << N) * 3;
				R -= 1 << N;
				C -= 1 << N;
			}
		}
		System.out.println(ans);
	}
}