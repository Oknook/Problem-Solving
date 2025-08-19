import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long before = 0;
        long now = 1;
        for (int j = 1; j < n; j++) {
            long tmp = now;
            now += before;
            before = tmp;
        }
        System.out.format("%d %d", now, n-2);
    }
}