import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            if (map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            al.add(entry.getValue());
        }
        al.sort(Comparator.reverseOrder());
        int cnt = 0;
        for (int i = 0; i < al.size(); i++) {
            cnt += al.get(i);
            answer++;
            if (cnt >= k) break;
        }

        return answer;
    }
}