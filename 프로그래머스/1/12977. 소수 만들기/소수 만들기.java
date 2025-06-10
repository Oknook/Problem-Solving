class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean net[] = new boolean[3001];
        net[1] = true;
        for (int i = 2; i < Math.sqrt(3000)+1; i++) {
            for (int j = 2; j * i <= 3000; j++) {
                net[i*j] = true;
            }
        }
        for (int p = 0; p < nums.length-2; p++) {
            for (int q = p+1; q < nums.length-1; q++) {
                for (int r = q+1; r < nums.length; r++) {
                    if (!net[nums[p]+nums[q]+nums[r]]) answer++;
                }
            }
        }
        return answer;
    }
}