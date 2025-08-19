import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int before = 0;
        int now = 1;
        for (int j = 1; j < n; j++) {
            int tmp = now;
            now += before;
            before = tmp;
        }
        System.out.println(now);
    }
}