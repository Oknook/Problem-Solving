import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int nums[] = new int[44];
        int n = 0;
        for (int i = 1; i <= 44; i++) {
            n += i;
            nums[i-1] = n;
        }

        boolean[] bools = new boolean[1001];
        for (int i = 0; i < 44; i++) {
            for (int j = 0; j < 44; j++) {
                for (int k = 0; k < 44; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if (tmp > 1000) continue;
                    bools[tmp] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            sb.append(bools[Integer.parseInt(br.readLine())] ? 1+"\n" : 0+"\n");
        }
        System.out.println(sb);
    }
}