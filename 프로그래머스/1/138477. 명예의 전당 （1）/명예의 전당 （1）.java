import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            al.add(score[i]);
            al.sort(Comparator.naturalOrder());
            if (al.size() < k) answer[i] = al.get(0);
            else answer[i] = al.get(al.size()-k);
        }
        return answer;
    }
}