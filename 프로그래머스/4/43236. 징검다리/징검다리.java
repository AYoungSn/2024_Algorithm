import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = distance;
        Arrays.sort(rocks);
        while (left <= right) {
            int mid = (left + right)/2;
            if (getRemoveRockCnt(rocks, mid, distance) <= n) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    public int getRemoveRockCnt(int[] rocks, int mid, int distance) {
        int s = 0;
        int e = distance;
        int cnt= 0;
        for(int i = 0; i < rocks.length; i++) {
            if (rocks[i] - s < mid) {
                cnt++;
            } else {
                s = rocks[i];
            }
        }
        if (distance - s < mid) {
            cnt++;
        }
        return cnt;
    }
}