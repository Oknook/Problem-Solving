import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] mat = new String[n][n];
        for (int i = 0; i < mat.length; i++)
            Arrays.fill(mat[i], " ");
        for (int i = 0; i < arr1.length; i++) {
            String str = String.format("%"+n+"s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') mat[i][j] = "#";
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            String str = String.format("%"+n+"s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') mat[i][j] = "#";
            }
        }
        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (int j = 0; j < n; j++) {
                tmp += mat[i][j];
            }
            answer[i] = tmp;
        }
        return answer;
    }
}