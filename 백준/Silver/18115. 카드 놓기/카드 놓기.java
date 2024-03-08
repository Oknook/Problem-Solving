import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> skills = new ArrayDeque<>();
        Deque<Integer> cards = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            skills.add(Integer.parseInt(st.nextToken()));
        }
        int card = 1;
        while (!skills.isEmpty()) {
            switch (skills.pollLast()) {
                case 1:
                    cards.addFirst(card++);
                    break;
                case 2:
                    if (!cards.isEmpty()) {
                        int tmp = cards.poll();
                        cards.addFirst(card++);
                        cards.addFirst(tmp);
                    }
                    break;
                case 3:
                    cards.addLast(card++);
                    break;
            }
        }
        while (!cards.isEmpty()) {
            bw.write(cards.poll()+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}