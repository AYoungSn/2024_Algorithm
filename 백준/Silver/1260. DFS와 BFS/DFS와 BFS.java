import java.util.*;
import java.io.*;
public class Main {
    static int N, M, V;
    static List<Integer>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i < N + 1; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }
        boolean[] visited = new boolean[N + 1];
        visited[V] = true;
        System.out.print(V + " ");
        dfs(V, visited);
        System.out.println();
        System.out.print(V + " ");
        bfs();
    }

    static void dfs(int cur, boolean[] visited) {
        for (int next :
                graph[cur]) {
            if (!visited[next]) {
                System.out.print(next + " ");
                visited[next] = true;
                dfs(next, visited);
            }
        }
    }

    static void bfs() {
        Queue<Integer> pq = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        pq.add(V);
        visited[V] = true;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            for (Integer next :
                    graph[cur]) {
                if (!visited[next]) {
                    System.out.print(next + " ");
                    visited[next] = true;
                    pq.add(next);
                }
            }
        }
    }
}
