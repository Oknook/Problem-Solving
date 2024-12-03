import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);

        boolean[] sieve = new boolean[90000];
        sieve[0] = true;
        sieve[1] = true;
        for (int i = 3; i < 90000; i += 2) {
            if (i % 2 == 0) sieve[i] = true;
            if (!sieve[i]) {
                set.add(i);
                for (int j = 1; i*j < 90000; j += 2) {
                    sieve[i*j] = true;
                }
            }
        }
        arr = set.stream().mapToInt(Integer::intValue).toArray();
        set = new TreeSet<>();
        sieve = new boolean[1];

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());
            if (n <= 89989) sb.append(upperBound(n) + "\n");
            else {
                for (long j = n; j <= 2*n; j++) {
                    boolean flag = true;
                    for (int num : arr) {
                        if (j % num == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        sb.append(j + "\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
    public static int upperBound(long target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[low];
    }
}