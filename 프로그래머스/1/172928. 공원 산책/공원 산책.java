import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        boolean[][] mat = new boolean[park.length][park[0].length()];
        int pX = 0, pY = 0;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'X') continue;
                mat[i][j] = true;
                if (park[i].charAt(j) == 'S') {
                    pY = i;
                    pX = j;
                }
            }
        }
        int dy[] = {-1, 0, 1, 0};
        int dx[] = {0, 1, 0, -1};
        for (String str : routes) {
            StringTokenizer st = new StringTokenizer(str);
            int d = 0;
            switch (st.nextToken().charAt(0)) {
                case 'E':
                    d = 1;
                    break;
                case 'S':
                    d = 2;
                    break;
                case 'W':
                    d = 3;
                    break;
            }
            int cnt = Integer.parseInt(st.nextToken());

            boolean flag = true;
            for (int i = 1; i <= cnt; i++) {
                int newY = pY + i*dy[d];
                int newX = pX + i*dx[d];
                if (newX < 0 || newX >= park[0].length() || newY < 0 || newY >= park.length || !mat[newY][newX]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                pY += cnt * dy[d];
                pX += cnt * dx[d];
            }
        }
        return new int[]{pY, pX};
    }
}