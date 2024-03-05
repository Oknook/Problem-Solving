import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M, permutation[];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        permutation = new int[M];

        repetitionPermutation(0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void repetitionPermutation(int idx) throws IOException {
        if (idx == M) {
            for (int j = 0; j < M; j++) {
                bw.write(permutation[j]+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            permutation[idx] = i;
            repetitionPermutation(idx+1);
        }
    }
}