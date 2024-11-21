import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer length = new StringTokenizer(br.readLine());
        StringTokenizer growth = new StringTokenizer(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(growth.nextToken());
            arr[i][1] = Integer.parseInt(length.nextToken());
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return 1;
            else return a[0] - b[0];
        });

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i*arr[i][0] + arr[i][1];
        }
        System.out.println(ans);
    }
}