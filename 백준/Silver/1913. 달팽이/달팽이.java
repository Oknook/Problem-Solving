import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int px = -1;
        int py = -1;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][] map = new int[n][n];
        int x = 0;
        int y = 0;
        int d = 0;
        for (int i = n*n; i > 0; i--) {
            map[y][x] = i;
            if (m == i) {
                px = x;
                py = y;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[ny][nx] != 0) {
                d++;
                d %= 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }

            x = nx;
            y = ny;
        }

        for (int[] arr : map) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println((py+1) + " " + (px+1));
    }
}