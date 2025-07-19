import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }
        int[] cnt = new int[want.length];
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i])) cnt[map.get(discount[i])]++;
        }
        if (Arrays.compare(cnt, number) == 0) answer++;

        for (int i = 10; i < discount.length; i++) {
            if (map.containsKey(discount[i])) cnt[map.get(discount[i])]++;
            if (map.containsKey(discount[i-10])) cnt[map.get(discount[i-10])]--;
            if (Arrays.compare(cnt, number) == 0) answer++;
        }
        return answer;
    }
}