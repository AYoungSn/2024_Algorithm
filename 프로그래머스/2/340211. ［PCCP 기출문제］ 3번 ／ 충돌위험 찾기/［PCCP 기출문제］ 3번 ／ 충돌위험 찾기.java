class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int[][] cur = new int[routes.length + 1][2];
        int[][] end = new int[routes.length + 1][2];
        int[] cur_point = new int[routes.length];
        for (int i = 0; i < routes.length; i++) {
            cur[i][0] = points[routes[i][0] - 1][0];
            cur[i][1] = points[routes[i][0] - 1][1];
            end[i][0] = points[routes[i][1] - 1][0];
            end[i][1] = points[routes[i][1] - 1][1];
            cur_point[i] = 2;
            // System.out.println("cur[" + i + "] = " + cur[i][0] + ", " + cur[i][1]);
        }
        boolean check = true;
        int timer = 0;
        while (check) {
            check = false;
            int[][] board = new int[101][101];
            for (int i = 0;i < routes.length; i++) {
                if (cur[i][0] > 0) {
                    check = true;
                    int r = cur[i][0];
                    int c = cur[i][1];
                    int er = end[i][0];
                    int ec = end[i][1];
                    if (board[r][c] == 0) {
                        board[r][c] = 1;
                        // System.out.println(i + ": " + r + ", " + c + ", er, ec: " + er + ", " + ec);
                    } else if (board[r][c] == 1) {
                        answer++;
                        board[r][c] = 2;
                        // System.out.println(i + ": " + r + ", " + c + ", er, ec: " + er + ", " + ec);
                    }
                    if (r == er && c == ec) {
                        if (routes[0].length > cur_point[i]) {
                            end[i][0] = points[routes[i][cur_point[i]] - 1][0];
                            end[i][1] = points[routes[i][cur_point[i]] - 1][1];
                            er = end[i][0];
                            ec = end[i][1];
                            cur_point[i]++;
                        }
                    }
                    if (Math.abs(r - er) != 0) {
                        if (r < er) {
                            r += 1;
                        } else {
                            r -= 1;
                        }
                    } else {
                        if (c < ec) {
                            c++;
                        } else if (c > ec) {
                            c--;
                        } else {
                            r = 0;
                            c = 0;
                        }
                    }
                    cur[i][0] = r;
                    cur[i][1] = c;
                }
            }
        }
        
        return answer;
    }
}