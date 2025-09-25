import java.util.*;

class Solution {
    static boolean[] prime = new boolean[10000000];
    static int n, num[], res[];
    static boolean visit[];
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i < 10000000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < 10000000; j += i) {
                    prime[j] = true;
                }
            }
        }
        
        n = numbers.length();
        num = new int[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            num[i] = numbers.charAt(i)-'0';
        }
        
        for (int i = 1; i <= n; i++) {
            res = new int[n];
            Arrays.fill(res, -1);
            permutation(0, i);
        }
        return set.size();
    }
    
    static void permutation(int depth, int m) {
        if (depth == m) {
            int index = 0;
            int tmp = 0;
            while (index < n && res[index] != -1) {
                tmp = tmp*10+res[index++];
            }
            if (!prime[tmp]) set.add(tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                res[depth] = num[i];
                permutation(depth + 1, m);
                visit[i] = false;
            }
        }
    }
}