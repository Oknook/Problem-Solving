import java.util.stream.*;

class Solution {
    public String solution(String my_string) {
        return my_string
            .toLowerCase()
            .chars()
            .mapToObj(i -> String.valueOf((char)i))
            .sorted()
            .collect(Collectors.joining());
    }
}