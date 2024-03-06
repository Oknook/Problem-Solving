import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            int num = Integer.parseInt(br.readLine());
            int origin = num;
            int answer = 0;
            int cnt = 0;
            while (cnt != 1023) {
                while (num > 0) {
                    cnt |= 1 << (num%10);
                    num /= 10;
                }
                answer++;
                num = (answer+1)*origin;
            }
            bw.write("#"+i+" "+answer*origin+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
	}
}