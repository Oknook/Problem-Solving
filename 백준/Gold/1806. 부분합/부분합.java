import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] >= s) {
                System.out.println(1);
                return;
            }
            total += arr[i];
        }
        if (total < s) {
            System.out.println(0);
            return;
        }
        else if (total == s) {
            System.out.println(n);
            return;
        }

        int answer = Integer.MAX_VALUE;
        int p = 0, q = 1, sum = arr[p]+arr[q];
        while (!(q == n-1 && sum < s)) {
            if (sum >= s) {
                if (q-p == 1) {
                    System.out.println(2);
                    return;
                }
                answer = Math.min(answer, q-p+1);
                sum -= arr[p];
                p++;
            }
            else {
                q++;
                sum += arr[q];
            }
        }
        System.out.println(answer);
        br.close();
    }
}