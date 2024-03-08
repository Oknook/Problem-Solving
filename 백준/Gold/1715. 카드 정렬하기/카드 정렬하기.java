import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        long ans = 0;
        int a = q.size();
        while (a > 2) {
            int tmp = q.poll()+q.poll();
            q.add(tmp);
            ans += tmp;
            a--;
        }
        System.out.println(ans+q.poll()+q.poll());

        br.close();
    }
}