import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;
        int arr[] = new int[2*n];
        for (int i = 0; i < n; i++) {
            arr[i] = elements[i];
            arr[i+n] = elements[i];
        }
        for (int i = 0; i < 2*n-1; i++) {
            for (int k = 1; k <= n; k++) {
                int cnt = 0;
                for (int j = 0; j < k && i+j < 2*n-1; j++) {
                    cnt += arr[i+j];
                }
                set.add(cnt);
            }
        }
        return set.size();
    }
}