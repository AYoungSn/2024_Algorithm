import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
public class Main {
//    static int[][] graph;
    static List<Node>[] graph;
    static Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    });
//    static List<Integer>[] graph;
    static int[] path;
    static int V, E, start;

    public static void main(String[] args) throws Exception{
        // 다익스트라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
//        graph = new int[V + 1][V + 1];
        graph = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
//            graph[u][v] = w;
            graph[u].add(new Node(v, w));
        }

        boolean[] vst = new boolean[V + 1];
        path = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            path[i] = Integer.MAX_VALUE;
        }
        path[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (vst[curr[0]]) {
                continue;
            }
//            System.out.println("curr: " + Arrays.toString(curr));
            vst[curr[0]] = true;
            path[curr[0]] = curr[1];
            for (int i = 0; i < graph[curr[0]].size(); i++) {
                if (path[graph[curr[0]].get(i).end] > path[curr[0]] + graph[curr[0]].get(i).weight) {
                    path[graph[curr[0]].get(i).end] = path[curr[0]] + graph[curr[0]].get(i).weight;
                    pq.add(new int[]{graph[curr[0]].get(i).end, curr[1] + graph[curr[0]].get(i).weight});
                }
            }
        }
        for (int i = 1; i < V+1; i++) {
            if (i == start) {
                System.out.println(0);
            } else if (path[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(path[i]);
            }
        }
    }
}
