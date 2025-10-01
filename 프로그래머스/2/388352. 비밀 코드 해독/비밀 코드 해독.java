class Solution {
    static int answer = 0, N, ANS[];
    static boolean[][] Q;
    public int solution(int n, int[][] q, int[] ans) {
        Q = new boolean[q.length][n+1];
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < q[0].length; j++) {
                Q[i][q[i][j]] = true;
            }
        }
        
        N = n;
        ANS = ans;
        int[] comb = new int[5];
        combination(1, 0, comb);
        
        return answer;
    }
    
    static void combination(int start, int depth, int[] comb) {
        if (depth == 5) {
            score(comb);
            return;
        }

        for (int i = start; i <= N; i++) {
            comb[depth] = i;
            combination(i+1, depth+1, comb);
        }
    }
    
    static void score(int[] comb) {
        boolean[] mq = new boolean[N+1];
        for (int i : comb) {
            mq[i] = true;
        }
        
        int[] myAns = new int[ANS.length];
        for (int i = 0; i < Q.length; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (Q[i][j] && mq[j]) cnt++;
            }
            myAns[i] = cnt;
        }
        
        boolean flag = true;
        for (int i = 0; i < ANS.length; i++) {
            if (ANS[i] != myAns[i]) {
                flag = false;
                break;
            }
        }
        if (flag) answer++;
    }
}