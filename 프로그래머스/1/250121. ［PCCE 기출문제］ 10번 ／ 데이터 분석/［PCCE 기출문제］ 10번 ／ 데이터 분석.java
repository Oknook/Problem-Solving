import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        ArrayList<int[]> al = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i][map.get(ext)] < val_ext) al.add(data[i]);
        }
        al.sort(Comparator.comparingInt(a -> a[map.get(sort_by)]));
        
        int[][] answer = al.toArray(new int[al.size()][]);
        
        return answer;
    }
}