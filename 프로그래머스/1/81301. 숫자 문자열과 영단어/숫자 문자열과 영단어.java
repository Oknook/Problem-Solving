class Solution {
    public int solution(String s) {
        String[][] strs = {
                {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}
                , {"0","1","2","3","4","5","6","7","8","9"}
        };
        for (int i = 0; i < 10; i++) {
            while (s.indexOf(strs[0][i]) != -1) {
                s = s.replaceAll(strs[0][i], strs[1][i]);
            }
        }
        return Integer.parseInt(s);
    }
}