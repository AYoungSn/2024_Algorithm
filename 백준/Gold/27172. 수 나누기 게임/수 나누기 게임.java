import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] card;
	static int[] score;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		score = new int[1000001];
		card = new int[1000001];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			card[arr[n]] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = arr[i] * 2; j < 1000001; j += arr[i]) {
				if (card[j] == 1) {
					++score[arr[i]];
					--score[j];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(score[arr[i]]).append(' ');
		}
		System.out.println(sb);
	}
}
