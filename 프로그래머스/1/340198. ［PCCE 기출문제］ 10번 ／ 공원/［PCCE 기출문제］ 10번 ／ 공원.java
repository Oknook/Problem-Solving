import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int row = park.length;
        int col = park[0].length;
        boolean mat[][] = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (park[i][j].equals("-1")) mat[i][j] = true;
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j]) {
                    cnt = Math.max(1, cnt);
                    for (int d = 1; i+d < row && j+d < col; d++) {
                        boolean flag = true;
                        for (int a = i; a <= i+d; a++) {
                            if (!mat[a][j+d]) {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) break;
                        for (int b = j; b < j+d; b++) {
                            if (!mat[i+d][b]) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) cnt = Math.max(d+1, cnt);
                        else break;
                    }
                }
            }
        }
        Arrays.sort(mats);
        for (int i = mats.length-1; i >= 0; i--) {
            if (mats[i] <= cnt) {
                return mats[i];
            }
        }
        return -1;
    }
}