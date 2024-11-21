import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean flag = true, flag2 = true;
    static boolean[][] bingo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new boolean[5][5];
        HashMap<Integer, Integer[]> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = false;
                map.put(Integer.parseInt(st.nextToken()), new Integer[]{i, j});
            }
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }
        }
        int cnt = 0;
        int answer = 0;
        while (!q.isEmpty()) {
            int num = q.poll();
            if (q.isEmpty()) {
                System.out.println("25");
                break;
            }
            int y = map.get(num)[0];
            int x = map.get(num)[1];
            bingo[y][x] = true;
            answer++;
            cnt = check(x, y, cnt);
            if (cnt >= 3) {
                System.out.println(answer);
                break;
            }
        }
    }
    static int check(int x, int y, int cnt) {
        int res = cnt;
        if (flag && bingo[0][0] && bingo[1][1] && bingo[2][2] && bingo[3][3] && bingo[4][4]) {
            res++;
            flag = false;
        }
        if (flag2 && bingo[0][4] && bingo[1][3] && bingo[2][2] && bingo[3][1] && bingo[4][0]) {
            res++;
            flag2 = false;
        }
        if (bingo[y][0] && bingo[y][1] && bingo[y][2] && bingo[y][3] && bingo[y][4]) {
            res++;
        }
        if (bingo[0][x] && bingo[1][x] && bingo[2][x] && bingo[3][x] && bingo[4][x]) {
            res++;
        }

        return res;
    }
}