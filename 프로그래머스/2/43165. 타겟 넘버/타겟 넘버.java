class Solution {
    int[] nums;
    int tg;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        tg = target;
        nums = numbers;
        solve(0, 0);
    
        return answer;
    }
    void solve(int idx, int num) {
        if (idx == nums.length) {
            if (num == tg) {
                answer += 1;
                
            }
            return;
        }
        solve(idx + 1, num + nums[idx]);
        solve(idx + 1, num - nums[idx]);
    }
}