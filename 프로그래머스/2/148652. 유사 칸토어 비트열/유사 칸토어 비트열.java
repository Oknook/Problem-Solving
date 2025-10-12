class Solution {
    public int solution(int n, long l, long r) {
        return (int)count(n, l, r);
    }
    
    public long count(int n, long start, long end) {
        if (start > end) return 0;
        if (n == 0) return 1;

        long len_prev = (long) Math.pow(5, n - 1);
        long total_count = 0;

        for (int i = 1; i <= 5; i++) {
            long piece_start = (i - 1) * len_prev + 1;
            long piece_end = i * len_prev;
            
            if (i == 3) {
                continue;
            }

            if (start > piece_end || end < piece_start) {
                continue;
            }
            
            long current_start = Math.max(start, piece_start);
            long current_end = Math.min(end, piece_end);

            long new_start = current_start - (piece_start - 1);
            long new_end = current_end - (piece_start - 1);
            
            total_count += count(n - 1, new_start, new_end);
        }

        return total_count;
    }
}