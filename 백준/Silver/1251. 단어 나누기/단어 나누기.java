import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<String> al = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                StringBuilder sb = new StringBuilder(str.substring(0, i));
                StringBuilder sb2 = new StringBuilder(str.substring(i, j));
                StringBuilder sb3 = new StringBuilder(str.substring(j));
                StringBuilder res = new StringBuilder();
                res.append(sb.reverse()).append(sb2.reverse()).append(sb3.reverse());
                al.add(res.toString());
            }
        }
        Collections.sort(al);
        System.out.println(al.get(0));
    }
}