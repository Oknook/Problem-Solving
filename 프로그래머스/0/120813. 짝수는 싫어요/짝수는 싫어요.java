import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        return IntStream.rangeClosed(1, n).filter(m -> m%2 == 1).toArray();
    }
}