import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt(); // 수열의 크기
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt(); // 수열의 원소들
        }
        
        System.out.println(maxSumIncreasingSubsequence(A, N));
    }

    public static int maxSumIncreasingSubsequence(int[] A, int N) {
        int[] dp = new int[N];
        
        // 초기화: dp[i]는 A[i] 자체로 끝나는 증가 부분 수열의 합
        for (int i = 0; i < N; i++) {
            dp[i] = A[i];
        }

        // 동적 프로그래밍으로 dp 배열 채우기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }

        // dp 배열에서 최대 값 찾기
        int maxSum = dp[0];
        for (int i = 1; i < N; i++) {
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }

        return maxSum;
    }
}