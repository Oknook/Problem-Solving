import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.add(i);
            map.put(i, Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int tmp = deque.pollFirst();
            sb.append(tmp + " ");
            if (deque.isEmpty()) break;

            if (map.get(tmp) > 0) {
                for (int i = 0; i < map.get(tmp)-1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            }
            else {
                for (int i = 0; i > map.get(tmp); i--) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
}