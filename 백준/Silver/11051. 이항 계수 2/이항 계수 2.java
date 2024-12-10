import java.util.*;
import java.io.*;

public class Main {
    static int[][] memos = new int[1001][1001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(dp(N, K));
    }
    static int dp(int n, int k) {
        if (k == 0 || k == n) return 1;
        if (memos[n][k] != 0) return memos[n][k];
        memos[n][k] = (dp(n - 1, k - 1) + dp(n - 1, k)) % 10007;

        return memos[n][k];
    }

}