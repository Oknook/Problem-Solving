class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int p = 0, q = 0;
        for (int i = 0; i < goal.length; i++) {
            boolean flag = goal[i].equals(cards1[p]);
            boolean flag2 = goal[i].equals(cards2[q]);
            if (!(flag || flag2)) return "No";
            if (flag) p = (p+1)%cards1.length;
            else if (flag2) q = (q+1)%cards2.length;
        }
        return answer;
    }
}