import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1, right = (long)times[0] * n;
        while (left <= right) {
            long mid = (left + right) /2;
            long tmp = 0;
            for (int time : times) {
                tmp += (mid / time);
            }
            if (tmp >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}