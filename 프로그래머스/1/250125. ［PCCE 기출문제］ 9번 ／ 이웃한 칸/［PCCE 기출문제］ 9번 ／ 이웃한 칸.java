class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {1, 0, -1, 0};
        int[] dw = {0, 1, 0, -1};
        for (int d = 0; d < 4; d++) {
            int nh = h + dh[d];
            int nw = w + dw[d];
            if (nh < 0 || nw < 0 || nh >= board.length || nw >= board[0].length) continue;
            if (board[h][w].equals(board[nh][nw])) answer++;
        }
        return answer;
    }
}