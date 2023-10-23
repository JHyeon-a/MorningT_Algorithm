package BOJ_11060_S2_점프점프;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//N: 개수
		int[] arr = new int[N+1];	//arr: 각 칸에 쓰인 정수
		int[] dp = new int[1001];	//dp: dp 배열
		
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//dp 배열 모두 최대값으로 채우고
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[1] = 0;	//dp[1]은 0에서 시작
		
		//1부터 N-1까지 (N-1까지가 N까지 도달할 수 있는 걸 계산할 수 있는 값이기 때문에)
		for(int i=1; i<=N-1; i++) {
			//만약 점프 할 수 있는 칸의 값이 0보다 크고 dp[i]가 갈 수 없는 칸이 아니라면(Intger.MAX_VALUE로 되어 있지 않는다면)
			if(arr[i] != 0 && dp[i] != Integer.MAX_VALUE) {
				//arr[i]까지 한 칸 플러스 해서 dp[i+j]까지 가는데 가장 최단 거리를 저장한다.
				for(int j=1; j<=arr[i]; j++) {
					if(i+j <=N) {
						dp[i+j] = Math.min(dp[i]+1, dp[i+j]);
						
					}
				}
			//점프 할 수 없는 칸이거나 도착할 수 없는 칸이라면
			}else {
				continue;
			}
		}
		
		//일단 result를 -1로 설정한 뒤 
		int result = -1;
		
		//마지막 칸이 도달할 수 없는 칸이 아니라면 dp[N]으로 result 갱신
		if(dp[N] != Integer.MAX_VALUE) {
			result = dp[N];
		}
		
		//출력
		System.out.println(result);
		
	}//main

}
