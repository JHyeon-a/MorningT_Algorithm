//스터디 개인 문제

package BOJ_11052_S1_카드구매하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();				//N: 구매하려고 하는 카드의 개수
		int[] P = new int[N + 1];			//P: i개 들어있는 카드팩의 금액 배열

		//1부터 N까지의 카드팩 금액 입력 받기
		for (int i = 1; i < N + 1; i++) {
			P[i] = sc.nextInt();
		}
		//입력 끝
		
		int[] dp = new int[N + 1];		//dp: i개를 구매하려고 했을 때, 낼 수 있는 가장 최대의 금액을 담은 배열

		dp[0] = 0;		//0개 구매하려고 하면 0원이므로 dp[0] = 0
		dp[1] = P[1];	//1개 구매하려고 하면 방법이 1개 들어있는 카드팩 하나 사는 게 끝이니까 dp[1] = P[1];

		//2부터 N까지 돌면서 dp 구하기
		for (int i = 2; i < N + 1; i++) {
			int max = P[i];	//max: 최대값, 처음엔 i개 들어있는 카드팩의 금액이 가장 크다고 설정
			dp[i] = P[i];	//dp[i]에 P[i] 넣기
			if (i % 2 == 0) { // 만약 N이 짝수라면
				//i번부터 확인할 건데, 어디까지냐면 i/2까지!
				//ex) i가 6일 때, dp[6]+dp[0], dp[5]+dp[1], dp[4]+dp[2], dp[3]+dp[3] 이 4가지를 max값과 비교하면 된다. 
				for (int j = i; j >= i / 2; j--) {
					max = Math.max(max, dp[j] + dp[i - j]);
				}
			} else { // 만약 N이 홀수라면
				//i번부터 확인할 건데, 어디까지냐면 i/2이 되기 전까지!
				//ex) i가 5일 때, dp[5]+dp[0], dp[4]+dp[1], dp[3]+dp[2] 이 3가지를 max값과 비교하면 된다.
				for (int j = i; j > i / 2; j--) {
					max = Math.max(max, dp[j] + dp[i - j]);
				}
			}

			dp[i] = max;	//dp[i]에 가장 최대 금액인 max를 넣어준다.

		}

		System.out.println(dp[N]);	//N개 구매하려고 했을 때 가장 큰 금액은 dp[N]의 값과 같다.

	}// main

}
