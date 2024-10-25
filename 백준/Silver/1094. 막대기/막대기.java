import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < 7; i++) {
            if ((x&1) == 1) answer++;
            x = x>>1;
        }
        System.out.println(answer);
    }
}