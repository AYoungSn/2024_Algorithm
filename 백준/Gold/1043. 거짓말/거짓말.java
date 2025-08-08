import java.util.*;
import java.io.*;

public class Main {

    static int N, M; // N: 사람, M: 파티
    static int[] parent;
    static boolean[] people_know;
    static List<Integer>[] parties;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        people_know = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cnt; i++) {
            people_know[Integer.parseInt(st.nextToken())] = true;
        }
        String[] inputs;
        parties = new ArrayList[M + 1];
        // 같은 파티에 오는 사람들끼리 연관관계 이어줌
        for (int i = 1; i <= M; i++) {
            parties[i] = new ArrayList<>();
            inputs = br.readLine().split(" ");
            int party_num = Integer.parseInt(inputs[0]);
            if (party_num <= 1) {
                parties[i].add(Integer.parseInt(inputs[1]));
            }
            for (int j = 1; j < party_num; j++) {
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j + 1]);
                if (find(a) != find(b)) {
                    union(a, b);
                }
                parties[i].add(b);
            }
            parties[i].add(Integer.parseInt(inputs[1]));
        }
        // 진실을 아는 사람들간의 연관관계가 있으면 -> 진실을 아는 사람으로 체크
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (people_know[i] && !visited[i]) {
                int root = find(i);
                for (int j = 1; j <= N; j++) {
                    if (root == find(j)) {
                        people_know[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }
        int result = 0;
        // 진실을 아는 사람이 없어야 거짓 얘기 가능
        for (int p = 1; p <= M; p++) {
            boolean flag = true;
            for (Integer attend :
                    parties[p]) {
                if (people_know[attend]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result++;
            }
        }
        System.out.println(result);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static int find(int a) {
        if (parent[a] == a) {
            return parent[a];
        }
        return find(parent[a]);
    }
}
