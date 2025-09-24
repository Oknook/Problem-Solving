import java.util.*;

public class Solution {
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int n,m,mat[][];
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        mat = new int[n][m];
        for (int[] row : mat) {
            Arrays.fill(row, 0);
        }

        return bfs(maps);
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int bfs(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        mat[0][0] = 1;
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.row == n - 1 && p.col == m - 1) {
                return mat[p.row][p.col];
            }

            for (int d = 0; d < 4; d++) {
                int nr = p.row + dr[d];
                int nc = p.col + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (maps[nr][nc] == 1 && mat[nr][nc] == 0) {
                        mat[nr][nc] = mat[p.row][p.col] + 1;
                        queue.add(new Point(nr, nc));
                    }
                }
            }
        }
        return -1;
    }
}
