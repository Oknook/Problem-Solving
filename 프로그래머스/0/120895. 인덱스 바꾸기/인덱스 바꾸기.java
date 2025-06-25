class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        int n1 = Math.min(num1, num2);
        int n2 = Math.max(num1, num2);
        
        for (int i = 0; i < my_string.length(); i++) {
            if (i == n1) {
                answer += my_string.charAt(n2);
                continue;
            }
            if (i == n2) {
                answer += my_string.charAt(n1);
                continue;
            }
            answer += my_string.charAt(i);
        }
        
        return answer;
    }
}