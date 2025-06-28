import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int round = 1;
        int turn = 0;
        char before = words[0].charAt(words[0].length()-1);
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        
        boolean flag = true;
        for (int i = 1; i < words.length; i++) {
            turn = (turn+1) % n;
            if (turn == 0) round++;
            int tmp = set.size();
            set.add(words[i]);
            if (words[i].charAt(0) != before || tmp == set.size() || words[i].length() == 1) {
                flag = false;
                break;
            }
            before = words[i].charAt(words[i].length()-1);
        }
        if (flag) return new int[]{0, 0};
        return new int[]{++turn, round};
    }
}