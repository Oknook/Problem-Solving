import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Integer> in = new HashMap<>();
        HashMap<Integer, Integer> out = new HashMap<>();
        
        for (String str : records) {
            String strs[] = str.split(" ");
            String tmp[] = strs[0].split(":");
            int time = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
            int carNumber = Integer.parseInt(strs[1]);
            if ("OUT".equals(strs[2])) {
                int temp = 0;
                if (out.containsKey(carNumber)) temp = out.get(carNumber);
                out.put(carNumber, time-in.get(carNumber)+temp);
                in.remove(carNumber);
            }
            else {
                in.put(carNumber, time);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : in.entrySet()) {
            Integer carNumber = entry.getKey();
            Integer time = entry.getValue();
            int temp = 0;
            if (out.containsKey(carNumber)) temp = out.get(carNumber);
            out.put(carNumber, (23*60+59)-time+temp);
        }
        in.clear();
        
        int[][] answer = new int[out.size()][2];
        int index = 0;
        
        for (Map.Entry<Integer, Integer> entry : out.entrySet()) {
            Integer carNumber = entry.getKey();
            Integer time = entry.getValue();
            if (time <= fees[0]) {
                answer[index][0] = carNumber;
                answer[index][1] = fees[1];
            }
            else {
                answer[index][0] = carNumber;
                double num = time-fees[0];
                answer[index][1] = fees[1] + (int)(Math.ceil(num/(double)(fees[2])))*fees[3];
            }
            index++;
        }
        
        Arrays.sort(answer, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int result[] = new int[answer.length];
        for (int i = 0; i < answer.length; i++) {
            result[i] = answer[i][1];
        }
        
        return result;
    }
}