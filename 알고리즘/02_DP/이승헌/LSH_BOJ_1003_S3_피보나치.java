package BOJ_1003_S3_피보나치;

import java.util.Scanner;

public class Main {
	static int[][] dp;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			dp = new int[N + 1][2];

			dp[0][0] = 1;
			dp[0][1] = 0;
			if (N >= 1) {
				dp[1][0] = 0;
				dp[1][1] = 1;
			}
			fibo(2);
			StringBuilder sb = new StringBuilder();
			sb.append(dp[N][0]).append(" ").append(dp[N][1]);
			
			System.out.println(sb);
		}
	}

	private static void fibo(int n) {
		if(n > N) return;
		dp[n][0] = dp[n-1][0] + dp[n-2][0];
		dp[n][1] = dp[n-1][1] + dp[n-2][1];
		
		fibo(n+1);
	}
}
