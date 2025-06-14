class Solution {
    public int[] solution(String[] wallpaper) {
        int lRow = wallpaper.length, lCol = wallpaper[0].length(), rRow = 0, rCol = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lRow = Math.min(lRow, i);
                    lCol = Math.min(lCol, j);
                    rRow = Math.max(rRow, i);
                    rCol = Math.max(rCol, j);
                }
            }
        }
        return new int[]{lRow, lCol, rRow+1, rCol+1};
    }
}