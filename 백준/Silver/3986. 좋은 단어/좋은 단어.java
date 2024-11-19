import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;
    static Stack<Character> stack = new Stack<>();
    static Stack<Character> tmp = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() % 2 == 0) check(str);
        }
        System.out.println(answer);
    }
    static void check(String str) {
        stack.clear();
        tmp.clear();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            char c = stack.pop();

            if (!tmp.isEmpty()) {
                if (c == tmp.peek()) tmp.pop();
                else if (!stack.isEmpty() && stack.peek() == c) stack.pop();
                else tmp.push(c);
            }
            else {
                if (c == stack.peek()) stack.pop();
                else tmp.push(c);
            }
        }
        if (tmp.isEmpty()) answer++;
    }
}