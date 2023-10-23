package BOJ_1912_S2_연속합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];		//arr: 원본 수열
		int[] dp = new int[100001];		//dp: 그 해당까지의 만들 수 있는 연속합 중 가장 큰 수
		
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp[1] = arr[1]; //처음 dp[1]은 arr[1]로
		
		int max = dp[1];	//max도 dp[1]로
		
		//dp[i]: i번째까지의 최대 합 
		//만약 dp[i-1]이 0보다 작다면 arr[i]가 dp[i-1]+arr[i]보다 큰 값임
		for(int i=2; i<=N; i++) {
			if(dp[i-1]<0) {
				dp[i] = arr[i];
			}else {
				dp[i] = dp[i-1] + arr[i];
			}
			
			//최대값은 계속 갱신
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}//main

}
