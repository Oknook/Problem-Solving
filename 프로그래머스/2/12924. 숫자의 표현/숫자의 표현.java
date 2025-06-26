class Solution {
    public int solution(int n) {
        int answer = 0;
        int p = 1;
        while (p <= n) {
            int cnt = 0;
            for (int q = p;;q++) {
                cnt += q;
                if (cnt > n) break;
                else if (cnt == n){
                    answer++;
                    break;
                }
            }
            
            p++;
        }
        return answer;
    }
}