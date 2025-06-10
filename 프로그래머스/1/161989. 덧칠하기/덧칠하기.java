import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : section) pq.add(i);

        while (true) {
            int end = pq.peek()+m-1;
            while (!pq.isEmpty() && pq.peek() <= end) pq.poll();
            answer++;
            if (pq.isEmpty()) break;
        }
        return answer;
    }
}