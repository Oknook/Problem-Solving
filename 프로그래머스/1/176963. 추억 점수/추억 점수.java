import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            int tmp = 0;
            for (String index : photo[i]) {
                tmp += map.getOrDefault(index, 0);
            }
            answer[i] = tmp;
        }
        return answer;
    }
}