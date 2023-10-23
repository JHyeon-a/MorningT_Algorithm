package BOJ_9095_S3_123더하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();
			int[] dp = new int[11 + 1];

			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			for (int i = 4; i <= N; i++) {
				dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];

			}

			System.out.println(dp[N]);

		} // tc

	}// main

}
