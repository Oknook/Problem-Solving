class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int cnt = 0;
            int tmp = (int) Math.sqrt(i);
            for (int j = 1; j <= tmp; j++) {
                if (i % j == 0) cnt++;
            }
            cnt = tmp==Math.sqrt(i)?2*cnt-1:2*cnt;
            answer += cnt>limit?power:cnt;
        }
        return answer;
    }
}