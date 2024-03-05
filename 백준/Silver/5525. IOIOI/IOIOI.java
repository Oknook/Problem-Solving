import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        String P = "";
        for (int i = 0; i < N; i++) {
            P += "IO";
        }
        P += "I";

        int ans = 0;
        while (S.contains(P)) {
            S = S.substring(S.indexOf(P)+1);
            ans++;
        }
        System.out.println(ans);
    }
}