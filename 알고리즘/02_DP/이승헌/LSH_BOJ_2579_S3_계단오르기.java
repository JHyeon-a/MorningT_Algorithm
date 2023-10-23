package boj_2579_S3_계단오르기;

import java.util.Scanner;

public class Main {
	static int N; // 계단의 수
	static int[] stairs; // 계단 점수
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		stairs = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			stairs[i] = sc.nextInt();
		}
		dp[0] = stairs[0];
		dp[1] = stairs[1];

		if (N >= 2)
			dp[2] = dp[1] + stairs[2];

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
		}
		System.out.println(dp[N]);
	}
}
