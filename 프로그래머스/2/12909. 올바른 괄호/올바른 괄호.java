import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            s1.push(s.charAt(i));
        }
        while (!s1.isEmpty()) {
            if (s1.peek() == ')') s2.push(s1.pop());
            else if (s2.isEmpty()) {
                return false;
            }
            else {
                s1.pop();
                s2.pop();
            }
        }
        if (!s2.isEmpty()) return false;

        return true;
    }
}