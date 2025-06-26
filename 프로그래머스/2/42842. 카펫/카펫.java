class Solution {
    public int[] solution(int brown, int yellow) {
        int row = 3;
        int col = 3;
        for (col = 1; col <= Math.sqrt(brown+yellow); col++) {
            if ((brown+yellow) % col == 0) row = (brown+yellow) / col;
            if ((row-2)*(col-2) == yellow) break;
        }
        return new int[]{row, col};
    }
}