import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.add(i+1);
        }

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            Deque<Integer> p = new ArrayDeque<>(q);
            while (p.peek() != target && q.peek() != target) {
                answer++;
                if (!q.isEmpty()) q.addLast(q.pollFirst());
                if (!p.isEmpty()) p.addFirst(p.pollLast());
            }
            if (q.peek() == target) {
                q.pollFirst();
            }
            else if (p.peek() == target) {
                p.pollFirst();
                q = new ArrayDeque<>(p);
            }
        }
        System.out.println(answer);
    }
}