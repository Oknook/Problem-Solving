import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int p = 0;
        int q = people.length - 1;
        while (p <= q) {
            if (people[p] + people[q] <= limit) {
                p++;
                q--;
            }
            else q--;
            answer++;
        }
        return answer;
    }
}