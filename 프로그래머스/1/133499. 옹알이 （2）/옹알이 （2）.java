class Solution {
    static int answer = 0;
    static String cand[] = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        for (String str : babbling) check(str, "", -1);
        return answer;
    }

    static void check(String target, String point, int index) {
        if (point.length() > target.length()) return ;
        for (int i = 0; i < 4; i++) {
            if (i == index) continue;
            if (target.equals(point+cand[i])) {
                answer++;
                return;
            }
            else check(target, point+cand[i], i);
        }
    }
}