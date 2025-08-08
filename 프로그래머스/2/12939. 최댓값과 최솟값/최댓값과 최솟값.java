import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) throws Exception {
        StringTokenizer st = new StringTokenizer(s);
        int tmp = Integer.parseInt(st.nextToken());
        int tmp2 = Integer.parseInt(st.nextToken());
        int left = Math.min(tmp, tmp2);
        int right = Math.max(tmp, tmp2);
        while (st.hasMoreTokens()) {
            tmp = Integer.parseInt(st.nextToken());
            if (left > tmp) left = tmp;
            if (right < tmp) right = tmp;
        }
        return left + " " + right;
    }
}