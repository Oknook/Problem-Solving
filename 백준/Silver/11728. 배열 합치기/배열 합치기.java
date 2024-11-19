import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> treeSet = new TreeSet<>((o1, o2) -> {
            if (o1.equals(o2)) return -1;
            return o1-o2;
        });

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        for (int i : treeSet) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}