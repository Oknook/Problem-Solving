import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long sum1 = 0, sum2 = 0, total = 0;
        for (int n : queue1) {
            q1.offer(n);
            sum1 += n;
            total += n;
        }
        for (int n : queue2) {
            q2.offer(n);
            sum2 += n;
            total += n;
        }
        if (total % 2 != 0) return -1;
        long target = total / 2;

        int limit = (queue1.length + queue2.length) * 2;
        int cnt = 0;

        while(cnt <= limit) {
            if (sum1 == target) return cnt;

            if (sum1 > target) {
                if (q1.isEmpty()) return -1;
                int x = q1.poll();
                sum1 -= x;
                q2.offer(x);
            } else {
                if (q2.isEmpty()) return -1;
                int x = q2.poll();
                sum1 += x;
                q1.offer(x);
            }
            cnt++;
        }
        
        return -1;
    }
}