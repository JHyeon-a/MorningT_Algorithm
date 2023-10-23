package boj_점프점프_S2_11060;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] maze = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			maze[i] = sc.nextInt();
			dp[i] = 1001;
		}
		
		//dp
		dp[0] = 0;

		for (int i = 0; i < N - 1; i++) {
			int n = maze[i];
			for (int j = i + 1; j <= Math.min(N - 1, i + n); j++) {
				dp[j] = Math.min(dp[j], dp[i] + 1);
			}
		}

		//조건에 따라 출력
		if (dp[N - 1] == 1001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N - 1]);
		}

	}

}
