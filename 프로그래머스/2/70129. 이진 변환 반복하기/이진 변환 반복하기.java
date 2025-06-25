class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zeros = 0;
        while (!s.equals("1")) {
            String ss = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeros++;
                    continue;
                }
                else ss += "1";
            }
            s = String.valueOf(Integer.toBinaryString(ss.length()));
            cnt++;
        }
        return new int[]{cnt, zeros};
    }
}