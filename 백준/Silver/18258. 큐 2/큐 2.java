import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    q.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(Integer.toString(q.pollFirst())+"\n");
                    }
                    break;
                case "size":
                    bw.write(Integer.toString(q.size())+"\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        bw.write("1\n");
                    }
                    else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(Integer.toString(q.getFirst())+"\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(Integer.toString(q.getLast())+"\n");
                    }
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}