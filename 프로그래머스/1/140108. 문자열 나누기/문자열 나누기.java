class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int target = 0;
            int cnt = 0;
            int index = 0;
            while (index < s.length()) {
                if (s.charAt(index) == s.charAt(0)) target++;
                else {
                    if (target == ++cnt) {
                        answer++;
                        s = s.substring(index+1);
                        index = 0;
                        target = 0;
                        cnt = 0;
                        continue;
                    }
                }
                index++;
                if (index == s.length()) answer++;
            }
        
        return answer;
    }
}