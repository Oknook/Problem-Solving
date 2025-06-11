import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char tmp = key.charAt(i);
                if (!map.containsKey(tmp)) map.put(tmp, i+1);
                else map.put(tmp, Math.min(i+1, map.get(tmp)));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int cnt = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                if (!map.containsKey(targets[i].charAt(j))) {
                    cnt = -1;
                    break;
                }
                else cnt += map.get(targets[i].charAt(j));
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}