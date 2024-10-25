import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int answer = -1;
        for (int i = n-1; i >= 2; i--) {
            if (arr[i-2] + arr[i-1] > arr[i]) {
                answer = arr[i-2] + arr[i-1] + arr[i];
                break;
            }
        }
        System.out.println(answer);
    }
}