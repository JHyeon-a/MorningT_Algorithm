package BOJ_14501_S3_퇴사;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 일 수
		int[] dp = new int[N + 1]; // 해당 날짜에 최적의 해
		int[] time = new int[N + 1]; // 상담을 완료하는데 걸리는 시간
		int[] price = new int[N + 1]; // 상담을 할 경우 받을 수 있는 금액

		for (int i = 1; i <= N; i++) { // 상담 관련 시간과 금액 넣기
			time[i] = sc.nextInt();
			price[i] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) { // Bottom-up 방식
			int sum = 0;
			if (i + time[i] - 1 <= N) { // i 날짜에 상담을 시작해서 퇴사 전 끝낼 수 있나?
				// 상담 가능 -> i 날짜에 상담을 시작했을 때 이전 상담 금액 총합과 i 날짜 상담 금액의 합 
				sum = price[i] + dp[i - 1];
				// 이미 저장되어 있을 수 있으니 비교하여 더 큰 값을 저장한다.
				if (dp[i + time[i] - 1] < sum) dp[i + time[i] - 1] = sum;
			}
			// 바로 전 날의 값과 비교하여 전 날이 더 크다면 i 날짜를 스킵
			if (dp[i] < dp[i - 1]) dp[i] = dp[i - 1];
		}
		System.out.println(dp[N]);
		sc.close();
	}
}
