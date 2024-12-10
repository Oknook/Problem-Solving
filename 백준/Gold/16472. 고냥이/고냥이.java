import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] chars = br.readLine().toCharArray();
        int p = 0, q = 0, cnt = 0, ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = 'a';
            map.put((char)(c+i), 0);
        }
        map.put(chars[0], 1);
        cnt++;
        ans++;

        while (++p < chars.length) {
            if (map.get(chars[p]) > 0) {
                map.put(chars[p], map.get(chars[p])+1);
                ans = Math.max(ans, p-q+1);
            }
            else {
                map.put(chars[p], 1);
                cnt++;
                if (cnt <= N) {
                    ans = Math.max(p-q+1, ans);
                }
                else {
                    while (cnt > N) {
                        if (map.get(chars[q]) == 1) {
                            map.put(chars[q], 0);
                            q++;
                            cnt--;
                        }
                        else{
                            map.put(chars[q], map.get(chars[q])-1);
                            q++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}