import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        int index = 0;
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int tmp = set.size();
            set.add(arr[i]);
            if (tmp != set.size()) {
                answer[index++] = arr[i];
            }
            if (set.size() >= k) break;
        }
        for (int i = set.size(); i < k; i++) {
            answer[i] = -1;
        }
        return answer;
    }
}