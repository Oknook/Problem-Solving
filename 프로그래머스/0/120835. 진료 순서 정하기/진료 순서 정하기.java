import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] answer = new int[n];
        Integer[] tmp = new Integer[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = emergency[i];
        }
        Arrays.sort(tmp, (a, b) -> b-a);
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < n; i++) {
            map.put(tmp[i], index++);
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = map.get(emergency[i]);
        }

        return answer;
    }
}