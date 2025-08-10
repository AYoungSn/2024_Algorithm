import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int res = 1;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{B, 1});
        while (true) {
            int[] cur = que.poll();
            if (cur[0] % 10 == 1) {
                que.add(new int[]{cur[0] / 10, cur[1] + 1});
            }
            if (cur[0] % 2 == 0) {
                que.add(new int[]{cur[0] / 2, cur[1] + 1});
            }
            if (cur[0] == A) {
                System.out.println(cur[1]);
                break;
            }
            if ((cur[0] % 10 != 1 && cur[0] % 2 != 0) || cur[0] < A){
                System.out.println(-1);
                break;
            }
        }
    }

}