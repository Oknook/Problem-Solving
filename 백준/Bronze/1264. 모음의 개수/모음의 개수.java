import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("#")) break;
            str = str.toUpperCase()
                    .replace("A", "*")
                    .replace("E", "*")
                    .replace("I", "*")
                    .replace("O", "*")
                    .replace("U", "*");
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '*') num++;
            }
            System.out.println(num);
        }
    }
}