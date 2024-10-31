import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String key = br.readLine();
        int index = 0;
        int size = key.length();

        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char comp = key.charAt(index);

            if (ch == ' ') answer += " ";
            else if (ch - comp <= 0) answer += (char)('a' + ch - comp + 25);
            else answer += (char) ('a' + ch - comp - 1);
            index++;
            index %= size;
        }
        System.out.println(answer);
    }
}