class Solution {
    public int solution(int n, int w, int num) {
        int answer = (int)n/w - (int)(num - 1)/w;
        int floor = num / w + (num % w > 0 ? 1 : 0);
        int op = floor % 2 == 0 ? -1 : 1;
        int ind = floor % 2 == 0 ? w - 1 : 0;
        int s = (floor - 1) * w + 1;
        for (int i = 0; i <= w; i ++) {
            if (s == num) {
                break;
            }
            s++;
            ind += op;
        }
        // System.out.println(floor + ", " + ind + ", " + op + ", " + s);
        if (n % w > 0) {
            floor = n / w + 1;
            s = (n / w) * w + 1;
            op = floor % 2 == 0 ? -1 : 1;
            int id = floor % 2 == 0 ? w - 1 : 0;
            for(int i = 0; i <= w; i++) {
                if (s > n) {
                    break;
                }
                if (id == ind) {
                    answer++;
                    break;
                }
                id += op;
                s++;
            }
        }
        
        return answer;
    }
}