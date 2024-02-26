import java.io.*;

public class Main {
	static int N;
	static int[] inOrder, postOrder, preOrder;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inOrder = new int[N];
		postOrder = new int[N];
		preOrder = new int[N];
		String[] strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			inOrder[i] = Integer.parseInt(strs[i]);
		}
		strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			postOrder[i] = Integer.parseInt(strs[i]);
		}
		int rootIndex = N - 1;
		makePreOrder(0, N, 0, N, 0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(preOrder[i]).append(' ');
		}
		System.out.println(sb);
	}

	static int findRootIndex(int start, int end, int root, int[] order) {
		for (int i = start; i < end; i++) {
			if (order[i] == root) {
				return i;
			}
		}
		return -1;
	}
	static int makePreOrder(int start_in, int end_in, int start_post, int end_post, int idx) {
		if (start_in < 0 || start_in >= end_in || end_in > N || start_post < 0 || start_post >= end_post
			|| end_post > N || end_post == 0) {
			return idx - 1;
		}
		if (start_in == end_in) {
			preOrder[idx] = start_in;
		}
		// findRoot
		int root = findRootIndex(start_in, end_in, postOrder[end_post - 1], inOrder);
		preOrder[idx] = postOrder[end_post - 1];
		// left
		idx = makePreOrder(start_in, root, start_post, start_post + (root - start_in), ++idx);
		// right
		idx = makePreOrder(root + 1, end_in, start_post + (root - start_in), end_post - 1, ++idx);
		return idx;
	}
}
