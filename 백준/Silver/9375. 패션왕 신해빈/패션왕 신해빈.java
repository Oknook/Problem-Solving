import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String category = st.nextToken();
                if (map.containsKey(category)) map.put(category, map.get(category)+1);
                else map.put(category, 1);
            }
            int ans = 1;
            for (String str : map.keySet()) {
                ans *= map.get(str)+1;
            }
            System.out.println(ans-1);
        }
    }
}