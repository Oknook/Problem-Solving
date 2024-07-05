import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a[][] = new int[3][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[0][i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(a[1], 1);
        Arrays.fill(a[2], 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[0][i] > a[0][j]) a[1][i] = Math.max(a[1][j] + 1, a[1][i]);
            }
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = n-1; j > i; j--) {
                if (a[0][i] > a[0][j]) a[2][i] = Math.max(a[2][j] + 1, a[2][i]);
            }
        }
        int answer = 1;
        for (int i = 0; i < n; i++) {
            if (a[1][i] + a[2][i] > answer) answer = a[1][i] + a[2][i];
        }
        System.out.println(answer-1);
    }
}