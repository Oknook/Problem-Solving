import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static class Player {
        int cnt;
        int pos;
        public Player(int cnt, int pos) {
            this.cnt = cnt;
            this.pos = pos;
        }
    }
    static int ans = -1;
    static HashMap<Integer, Integer> warp = new HashMap<>();
    static HashMap<Integer, Integer> ladder = new HashMap<>();
    static HashMap<Integer, Integer> snake = new HashMap<>();
    static boolean[] visit = new boolean[150];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int enter = Integer.parseInt(st.nextToken());
            int exit = Integer.parseInt(st.nextToken());
            warp.put(enter, 0);
            ladder.put(enter, exit);
        }
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int enter = Integer.parseInt(st.nextToken());
            int exit = Integer.parseInt(st.nextToken());
            warp.put(enter, 1);
            snake.put(enter, exit);
        }
        Player player = new Player(0, 1);
        bfs(player);
        System.out.println(ans);
    }
    static void bfs(Player p) {
        Deque<Player> q = new LinkedList();
        visit[p.pos] = true;
        q.add(p);

        while (q.isEmpty() != true) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Player player = q.poll();
                for (int j = 1; j <= 6; j++) {
                    int newPos = player.pos+j;
                    if (warp.containsKey(newPos)) {
                        if (warp.get(newPos) == 0) {
                            newPos = ladder.get(newPos);
                        }
                        else {
                            newPos = snake.get(newPos);
                        }
                    }
                    if (newPos >= 100) {
                        ans = player.cnt+1;
                        return;
                    }
                    if (visit[newPos] != true) {
                        visit[newPos] = true;
                        Player newPlayer = new Player(player.cnt+1, newPos);
                        q.add(newPlayer);
                    }
                }
            }
        }
    }
}