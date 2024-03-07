import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int p = 0, q = n-1, a = 0, b = 0;
        while (p < q) {
            int tmp = arr[p]+arr[q];
            if (tmp == 0) {
                a = arr[p];
                b = arr[q];
                break;
            }
            else if (Math.abs(tmp) < min) {
                min = Math.abs(tmp);
                a = arr[p];
                b = arr[q];
            }

            if (tmp < 0) {
                p++;
            }
            else {
                q--;
            }
        }
        System.out.println(a+" "+b);

        br.close();
    }
}