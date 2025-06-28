class Solution {
    public long solution(int n) {
        long track[] = new long[n+3];
        track[1] = 1;
        track[2] = 1;
        for (int i = 1; i <=n; i++) {
            track[i+1] += track[i];
            track[i+1] %= 1234567;
            track[i+2] += track[i];
            track[i+2] %= 1234567;
        }
        return track[n];
    }
}