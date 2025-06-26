class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = Integer.bitCount(n);
        for (answer = n+1;;answer++) {
            if (cnt == Integer.bitCount(answer)) break;
        }
        return answer;
    }
}