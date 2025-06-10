import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        double d = Math.sqrt(n);
        for (int i = 1; i <= d; i++) {
            if (n%i == 0) answer++;
        }
        return n%d==0?2*answer-1:2*answer;
    }
}