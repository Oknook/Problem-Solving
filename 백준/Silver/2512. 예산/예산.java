import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] city = new int[n];
        int left = 0;
        int right = -1;
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, city[i]);
        }
        int m = Integer.parseInt(br.readLine());

        while (left <= right) {
            int mid = (left+right)/2;
            int budget = 0;
            for (int i = 0; i < n; i++) {
                if (city[i] > mid) budget += mid;
                else budget += city[i];
            }
            if (budget <= m) left = mid+1;
            else right = mid-1;
        }
        System.out.println(right);
    }
}