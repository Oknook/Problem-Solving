class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int di = n - 1;
        int pi = n - 1;

        while (di >= 0 && deliveries[di] == 0) di--;
        while (pi >= 0 && pickups[pi] == 0) pi--;

        while (di >= 0 || pi >= 0) {
            int far = Math.max(di, pi);
            answer += (long) (far + 1) * 2L;

            int remain = cap;
            while (remain > 0 && di >= 0) {
                if (deliveries[di] == 0) { di--; continue; }
                int use = Math.min(remain, deliveries[di]);
                deliveries[di] -= use;
                remain -= use;
                if (deliveries[di] == 0) di--;
            }

            remain = cap;
            while (remain > 0 && pi >= 0) {
                if (pickups[pi] == 0) { pi--; continue; }
                int use = Math.min(remain, pickups[pi]);
                pickups[pi] -= use;
                remain -= use;
                if (pickups[pi] == 0) pi--;
            }

            while (di >= 0 && deliveries[di] == 0) di--;
            while (pi >= 0 && pickups[pi] == 0) pi--;
        }
        return answer;
    }
}