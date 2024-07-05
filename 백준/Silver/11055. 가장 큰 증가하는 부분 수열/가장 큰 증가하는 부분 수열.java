import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a[][] = new int[2][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[0][i] = Integer.parseInt(st.nextToken());
            a[1][i] = a[0][i];
        }

        int answer = a[1][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[0][i] > a[0][j]) a[1][i] = Math.max(a[1][j] + a[0][i], a[1][i]);
                if (a[1][i] > answer) answer = a[1][i];
            }
        }
        System.out.println(answer);
    }
}