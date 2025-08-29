import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String ss = s;
        
        for (int i = 0; i < ss.length(); i++) {
            ss = ss+ss.charAt(0);
            ss = ss.substring(1, ss.length());
            
            Stack<Character> stack = new Stack<>();
            Stack<Character> tmp = new Stack<>();
            for (char c : ss.toCharArray()) {
                stack.push(c);
            }
            while (!stack.isEmpty()) {
                while (!tmp.isEmpty() && !stack.isEmpty() &&
                      ((stack.peek() == '[' && tmp.peek() == ']')
                       || (stack.peek() == '{' && tmp.peek() == '}')
                       || (stack.peek() == '(' && tmp.peek() == ')'))) {
                    tmp.pop();
                    stack.pop();
                }
                if (!stack.isEmpty()) tmp.push(stack.pop());
            }
            if (tmp.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}