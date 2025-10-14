class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int start = h1*3600+m1*60+s1;
        int end = h2*3600+m2*60+s2;
        if (start == 0) answer--;
        if (start <= 43200 && 43200 <= end) answer--;
        
        int dh = (h1 % 12) * 3600 + m1 * 60 + s1;
        int dm = (dh*12)%43200;
        int ds = (dh*720)%43200;
        
        for (int i = 0; i < end-start; i++) {
            // if (h2 != 23) printTime(dh, dm, ds, i);
            int ndh = dh+1;
            int ndm = dm+12;
            int nds = ds+720;
            
            if (ds <= dm && ndm < nds) answer++;
            if (ds <= dh && ndh < nds) answer++;
            
            dh = ndh%43200;
            dm = ndm%43200;
            ds = nds%43200;
        }
        int edh = (h2 % 12) * 3600 + m2 * 60 + s2;
        int edm = (edh * 12) % 43200;
        int eds = (edh * 720) % 43200;
        if (eds == edm) answer++;
        if (eds == edh) answer++;
        
        return answer;
    }
    // static void printTime(int dh, int dm, int ds, int sec) {
    //     int h = (dh / 3600) % 12;
    //     int m = (dm / 720) % 60;
    //     int s = (ds / 720) % 60;
    //     System.out.printf("[%5d sec] 시침=%2d시, 분침=%02d분, 초침=%02d초\n", sec, h, m, s);
    // }
}