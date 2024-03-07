import java.util.*;

class Solution {
    static class Point {
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<HashSet<Integer>> oil;
    static ArrayList<Integer> amount;
    static int idx = -1;
    static int[][] map;
    static boolean[][] visit;
    static int row = 0;
    static int col = 0;
    static int[][] lande;

    public static int solution(int[][] land) {
        row = land.length;
        col = land[0].length;
        lande = new int[row][col];
        map = new int[row][col];
        visit = new boolean[row][col];
        oil = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            HashSet<Integer> set = new HashSet<>();
            oil.add(set);
        }
        amount = new ArrayList<>();
        amount.add(0);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                lande[i][j] = land[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visit[i][j] && lande[i][j] == 1) {
                    bfs(i, j);
                }
                if (map[i][j] != 0) {
                    oil.get(j).add(-1 * map[i][j]);
                }
            }
        }
        int answer = 0;

        for (int i = 0; i < col; i++) {
            int ans = 0;
            List<Integer> l = new ArrayList<>(oil.get(i));
            for (Integer I : l) {
                ans += amount.get(I);
            }
            if (ans > answer) answer = ans;
        }

        return answer;
    }
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static void bfs(int X, int Y) {

        Deque<Point> q = new LinkedList<>();
        visit[X][Y] = true;
        q.add(new Point(X, Y));
        int cnt = 1;

        while(!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;
            map[x][y] = idx;
            for (int d = 0; d < 4; d++) {
                int nextX = x+dx[d];
                int nextY = y+dy[d];
                if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col || visit[nextX][nextY]) continue;
                if (lande[nextX][nextY] == 1) {
                    visit[nextX][nextY] = true;
                    q.add(new Point(nextX, nextY));
                    cnt++;
                }
            }
        }
        amount.add(cnt);
        idx--;
    }
}