import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array, int n) {
        return Arrays.stream(array).boxed().mapToInt(num -> num==n?1:0).sum();
    }
}