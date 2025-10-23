import java.util.*;

class Solution {
    public long solution(int[] sequence) {
    int len = sequence.length;
    long answer = Long.MIN_VALUE;
    
    long max_pos = Long.MIN_VALUE;
    long max_neg = Long.MIN_VALUE;

    for (int x : sequence) {
        long current_x = (long) x;
        
        long new_max_pos;
        if (max_neg == Long.MIN_VALUE) {
            new_max_pos = current_x;
        } else {
            new_max_pos = max_neg + current_x;
        }
        new_max_pos = Math.max(current_x, new_max_pos);
        
        long new_max_neg = Long.MIN_VALUE;
        if (max_pos != Long.MIN_VALUE) {
            new_max_neg = max_pos - current_x;
        }
        
        max_pos = new_max_pos;
        max_neg = new_max_neg;

        answer = Math.max(answer, max_pos);
        answer = Math.max(answer, max_neg);
    }
    
    long max_pos_neg = Long.MIN_VALUE;
    long max_neg_neg = Long.MIN_VALUE;

    for (int x : sequence) {
        long current_x_neg = (long) -x;

        long new_max_pos_neg;
        if (max_neg_neg == Long.MIN_VALUE) {
            new_max_pos_neg = current_x_neg;
        } else {
            new_max_pos_neg = max_neg_neg + current_x_neg;
        }
        new_max_pos_neg = Math.max(current_x_neg, new_max_pos_neg);
        
        long new_max_neg_neg = Long.MIN_VALUE;
        if (max_pos_neg != Long.MIN_VALUE) {
            new_max_neg_neg = max_pos_neg - current_x_neg;
        }
        
        max_pos_neg = new_max_pos_neg;
        max_neg_neg = new_max_neg_neg;

        answer = Math.max(answer, max_pos_neg);
        answer = Math.max(answer, max_neg_neg);
    }

    return answer;
    }
}