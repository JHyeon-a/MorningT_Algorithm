package BOJ_9095_S3_123더하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케 수

		for (int tc = 0; tc < T; tc++) {

			int n = sc.nextInt();

			int[] dp = new int[n + 1];

			dp[1] = 1;
			for (int i = 2; i <= n; i++) {
				if (i <= 3) {
					dp[i] = dp[i - 1] + dp[i - 2] + 1;
					continue;
				}
				dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
			}
			System.out.println(dp[n]);
		}
	}
}
