import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[][] arr = new int[3][10];
        for (int i = 0; i < X.length(); i++) {
            arr[0][X.charAt(i)-'0']++;
        }
        for (int j = 0; j < Y.length(); j++) {
            arr[1][Y.charAt(j)-'0']++;
        }
        Arrays.fill(arr[2], -1);
        for (int k = 0; k < 10; k++) {
            arr[2][k] = Math.min(arr[0][k], arr[1][k]);
        }
        for (int l = 9; l >= 0; l--) {
            answer += String.valueOf(l).repeat(arr[2][l]);
        }
        if ("".equals(answer)) answer = "-1";
        if (answer.matches("0+")) answer = "0";
        // else answer = String.valueOf(Integer.parseInt(answer));
        return answer;
    }
}