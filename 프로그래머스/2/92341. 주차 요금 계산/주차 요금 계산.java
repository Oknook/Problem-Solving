import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // [수정] 차량번호는 선행 0 보존을 위해 String으로 관리
        Map<String, Integer> in = new HashMap<>();
        // [수정] 차량번호 오름차순 정렬 보장을 위해 누적 시간은 TreeMap 사용
        Map<String, Integer> acc = new TreeMap<>();

        for (String line : records) {
            String[] parts = line.split(" ");
            String[] hm = parts[0].split(":");
            int time = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            String car = parts[1];
            String io = parts[2];

            if ("IN".equals(io)) {
                in.put(car, time);
            } else {
                // OUT
                int inTime = in.get(car);                   // 문제에서 입력 보장
                int dur = time - inTime;

                // [수정] getOrDefault로 누적
                acc.put(car, acc.getOrDefault(car, 0) + dur);
                in.remove(car);
            }
        }

        // [수정] 남아있는 차량 23:59 출차 간주
        // in.entrySet()은 순회 중 구조 변경(자체 삭제)만 안 하면 안전
        final int END = 23 * 60 + 59;
        for (Map.Entry<String, Integer> e : in.entrySet()) {
            String car = e.getKey();
            int inTime = e.getValue();
            int dur = END - inTime;
            acc.put(car, acc.getOrDefault(car, 0) + dur);
        }
        // [수정] 더 이상 사용 안 하므로 정리
        in.clear();

        // [수정] 요금 계산을 함수화
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        int[] result = new int[acc.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> e : acc.entrySet()) { // TreeMap으로 차량번호 오름차순 고정
            int total = e.getValue();
            result[idx++] = calcFee(total, baseTime, baseFee, unitTime, unitFee);
        }
        return result;
    }

    // [수정] 올림 계산을 분리해 안전성/가독성 확보
    private int calcFee(int total, int baseTime, int baseFee, int unitTime, int unitFee) {
        if (total <= baseTime) return baseFee;
        int extra = total - baseTime;
        int units = (int) Math.ceil(extra / (double) unitTime);
        return baseFee + units * unitFee;
    }
}
