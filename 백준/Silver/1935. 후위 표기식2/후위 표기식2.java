import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<Character, Double> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            map.put((char)('A'+i), Double.parseDouble(br.readLine()));
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('A' <= c && c <= 'Z') {
                stack.push(map.get(c));
            }
            else {
                double d1 = stack.pop();
                double d2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(d2+d1);
                        break;
                    case '-':
                        stack.push(d2-d1);
                        break;
                    case '*':
                        stack.push(d2*d1);
                        break;
                    case '/':
                        stack.push(d2/d1);
                        break;
                }
            }
        }
        System.out.format("%.2f", stack.peek());
    }
}