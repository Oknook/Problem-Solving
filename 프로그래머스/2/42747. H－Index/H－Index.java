class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int[] cnt = new int[1001];
        for (int i : citations) {
            for (int j = 0; j <= i && j <= 1000; j++) {
                cnt[j]++;
            }
        }
        for (int i = 1000; i >= 0; i--) {
            if (cnt[i] >= i) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}