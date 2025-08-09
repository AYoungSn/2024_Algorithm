

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T;t++) {
			int K = Integer.parseInt(br.readLine());
			Queue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
			Queue<Integer> minPq = new PriorityQueue<>(Comparator.naturalOrder());
			Map<Integer, Integer> mc = new HashMap<>();
			for(int k = 0; k < K;k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int val = Integer.parseInt(st.nextToken());
				if (str.equals("I")) {
					maxPq.add(val);
					minPq.add(val);
					if (mc.containsKey(val)) {
						mc.put(val, mc.get(val) + 1);
					} else {
						mc.put(val, 1);
					}
				} else {
					while(true) {
						int top;
						if (val == 1) {
							if (maxPq.isEmpty()) break;
							top = maxPq.poll();
						} else {
							if (minPq.isEmpty()) break;
							top = minPq.poll();
						}
						int cnt = mc.get(top);
						if (cnt > 0) {
							mc.put(top, cnt - 1);
							break;
						}
					}
				}
			}
			while(!maxPq.isEmpty() && mc.get(maxPq.peek()) <= 0) maxPq.poll();
			while(!minPq.isEmpty() && mc.get(minPq.peek()) <= 0) minPq.poll();
			if (maxPq.isEmpty() || minPq.isEmpty())
				System.out.println("EMPTY");
			else System.out.println(maxPq.poll() + " " + minPq.poll());
		}
	}
}
