import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 2) {
            System.out.println(1);
            return;
        }

        BigInteger before = BigInteger.valueOf(0);
        BigInteger now = BigInteger.valueOf(1);
        for (int j = 1; j < n; j++) {
            BigInteger tmp = now;
            now = now.add(before);
            before = tmp;
        }
        System.out.println(now);
    }
}