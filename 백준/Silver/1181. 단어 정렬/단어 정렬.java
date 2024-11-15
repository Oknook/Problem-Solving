import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> al = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            al.add(br.readLine());
        }
        al = al.stream().distinct()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(String::compareTo))
                .collect(Collectors.toCollection(ArrayList::new));
        al.forEach(System.out::println);
    }
}