import java.util.Arrays;

class Solution {
    public int solution(String[] arr) {
        int N = (arr.length / 2) + 1;
        int[] nums = new int[N];
        String[] ops = new String[N - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                nums[i / 2] = Integer.parseInt(arr[i]);
            } else {
                ops[i / 2] = arr[i];
            }
        }

        int[][] DP_max = new int[N][N];
        int[][] DP_min = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(DP_max[i], Integer.MIN_VALUE);
            Arrays.fill(DP_min[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            DP_max[i][i] = nums[i];
            DP_min[i][i] = nums[i];
        }

        for (int length = 2; length <= N; length++) {
            for (int i = 0; i <= N - length; i++) {
                int j = i + length - 1;
                for (int k = i; k < j; k++) {
                    String op = ops[k];
                    
                    int max_left = DP_max[i][k];
                    int min_left = DP_min[i][k];
                    int max_right = DP_max[k+1][j];
                    int min_right = DP_min[k+1][j];
                    
                    if (op.equals("+")) {
                        DP_max[i][j] = Math.max(DP_max[i][j], max_left + max_right);
                        DP_min[i][j] = Math.min(DP_min[i][j], min_left + min_right);
                    } else {
                        DP_max[i][j] = Math.max(DP_max[i][j], max_left - min_right);
                        DP_min[i][j] = Math.min(DP_min[i][j], min_left - max_right);
                    }
                }
            }
        }
        return DP_max[0][N - 1];
    }
}