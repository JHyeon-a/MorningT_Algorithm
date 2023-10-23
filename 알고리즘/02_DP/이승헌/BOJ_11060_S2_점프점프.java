package BOJ_11060_S2_점프점프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] jump = new int[N];

		for (int i = 0; i < N; i++) {
			jump[i] = sc.nextInt();
		}

		int[] dp = new int[N];
		dp[N - 1] = -1;

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		queue.add(0);
		while (!queue.isEmpty()) {
			int p = queue.poll();

			int d = p + jump[p];
			if (d >= N - 1) {
				dp[N - 1] = dp[p] + 1;
				break;
			}
			for (int k = p + 1; k <= d; k++) {
				if (!visited[k]) {
					dp[k] = dp[p] + 1;
					queue.add(k);
					visited[k] = true;
				}
			}
		}
		System.out.println(dp[N - 1]);
	}
}
