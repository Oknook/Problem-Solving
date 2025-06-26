import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> pitcher = new Stack<>();
        Stack<Character> catcher = new Stack<>();
        for (int i = s.length()-1; i >= 0; i--) {
            pitcher.push(s.charAt(i));
        }
        while (!pitcher.isEmpty()) {
            if (!catcher.isEmpty() && catcher.peek() == pitcher.peek()) {
                catcher.pop();
                pitcher.pop();
            }
            else {
                catcher.push(pitcher.pop());
            }
        }
        if (!catcher.isEmpty()) return 0;

        return 1;
    }
}