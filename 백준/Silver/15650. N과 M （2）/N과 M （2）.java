import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N, M, numbers[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		comb(0, 1);
	}
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i : numbers) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}