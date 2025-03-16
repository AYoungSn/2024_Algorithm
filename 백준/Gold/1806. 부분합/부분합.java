import java.util.*;
import java.io.*;

public class Main {
    static int N, S;
    static int[] num;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        num = new int[N + 1];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int low = 0, high = 0, sum = num[0], min = N + 1;
        while (true) {
            if (high == N) {
                break;
            }
            if (sum < S) {
                sum += num[++high];
            } else {
                if (min > high - low + 1) {
                    min = high - low + 1;
                }
                sum -= num[low++];
            }
        }
        if (min == N + 1) {
            System.out.println(0);
        }
        else
            System.out.println(min);
    }
}