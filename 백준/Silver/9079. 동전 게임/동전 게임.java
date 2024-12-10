import java.util.*;
import java.io.*;

public class Main {
    static class Target {
        private boolean[] coins, visit;
        private int cnt;
        Target(boolean[] coins, boolean[] visit, int cnt) {
            this.coins = coins;
            this.visit = visit;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            boolean[] coins = new boolean[9];
            boolean[] visit = new boolean[8];
            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    coins[3*i+j] = st.nextToken().charAt(0) == 'T';
                }
            }
            sb.append(bfs(new Target(coins, visit, 0))+"\n");
        }
        System.out.println(sb);
    }
    static ArrayDeque<Target> q;
    static int bfs(Target target) {
        q = new ArrayDeque<>();
        q.add(target);
        while (!q.isEmpty()) {
            Target currentTarget = q.poll();
            if (currentTarget.cnt >= 8) break;

            boolean flag = true;
            boolean flag2 = false;
            for (int i = 0; i < 9; i++) {
                flag &= currentTarget.coins[i];
                flag2 |= currentTarget.coins[i];
            }
            if (flag || !flag2) return currentTarget.cnt;

            for (int i = 0; i < 8; i++) {
                if (currentTarget.visit[i]) continue;
                boolean[] newCoins = new boolean[9];
                boolean[] newVisit = new boolean[8];
                for (int j = 0; j < 9; j++) {
                    newCoins[j] = currentTarget.coins[j];
                }
                for (int j = 0; j < 8; j++) {
                    newVisit[j] = currentTarget.visit[j];
                }
                switch (i) {
                    case 0:
                        newCoins[0] = !newCoins[0];
                        newCoins[3] = !newCoins[3];
                        newCoins[6] = !newCoins[6];
                        newVisit[i] = true;
                        q.offer(new Target(newCoins, newVisit, currentTarget.cnt+1));
                        break;
                    case 1:
                        newCoins[1] = !newCoins[1];
                        newCoins[4] = !newCoins[4];
                        newCoins[7] = !newCoins[7];
                        newVisit[i] = true;
                        q.offer(new Target(newCoins, newVisit, currentTarget.cnt+1));
                        break;
                    case 2:
                        newCoins[2] = !newCoins[2];
                        newCoins[5] = !newCoins[5];
                        newCoins[8] = !newCoins[8];
                        newVisit[i] = true;
                        q.offer(new Target(newCoins, newVisit, currentTarget.cnt+1));
                        break;
                    case 3:
                        newCoins[0] = !newCoins[0];
                        newCoins[1] = !newCoins[1];
                        newCoins[2] = !newCoins[2];
                        newVisit[i] = true;
                        q.offer(new Target(newCoins, newVisit, currentTarget.cnt+1));
                        break;
                    case 4:
                        newCoins[3] = !newCoins[3];
                        newCoins[4] = !newCoins[4];
                        newCoins[5] = !newCoins[5];
                        newVisit[i] = true;
                        q.offer(new Target(newCoins, newVisit, currentTarget.cnt+1));
                        break;
                    case 5:
                        newCoins[6] = !newCoins[6];
                        newCoins[7] = !newCoins[7];
                        newCoins[8] = !newCoins[8];
                        newVisit[i] = true;
                        q.offer(new Target(newCoins, newVisit, currentTarget.cnt+1));
                        break;
                    case 6:
                        newCoins[0] = !newCoins[0];
                        newCoins[4] = !newCoins[4];
                        newCoins[8] = !newCoins[8];
                        newVisit[i] = true;
                        q.offer(new Target(newCoins, newVisit, currentTarget.cnt+1));
                        break;
                    case 7:
                        newCoins[2] = !newCoins[2];
                        newCoins[4] = !newCoins[4];
                        newCoins[6] = !newCoins[6];
                        newVisit[i] = true;
                        q.offer(new Target(newCoins, newVisit, currentTarget.cnt+1));
                        break;
                }
            }
        }
        return -1;
    }
}