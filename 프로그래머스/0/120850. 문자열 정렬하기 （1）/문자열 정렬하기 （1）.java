import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> al = new ArrayList<>();
        for (char c : my_string.toCharArray()) {
            if (c >= '0' && c <= '9') al.add(c - '0');
        }
        Collections.sort(al);
        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}