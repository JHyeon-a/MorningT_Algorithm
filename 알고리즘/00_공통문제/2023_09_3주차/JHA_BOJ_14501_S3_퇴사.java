package BOJ_14501_퇴사_S3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//N: 상담 가능한 총 일수
		int[] dp = new int[N+1];	//dp 배열
		int[] date = new int[N+1];	//각 일마다 걸리는 상담 일수 배열
		int[] value = new int[N+1];	//얻을 수 있는 수익
		
		
		for(int n=1; n<=N; n++) {
			date[n] = sc.nextInt();
			value[n] = sc.nextInt();
		}//모두 입력 완료
		
		//뒤에서부터 돌리기
		for(int i=N; i>=1; i--) {
			//i번째부터 마지막날까지 일할 수 있다면 수익은 value[i]
			if(i+date[i]-1 == N) {
				dp[i] = value[i];
			//만약 i번째부터 일해야 하는 날짜가 퇴사 날짜보다 크면 수익은 0
			} else if(i+date[i]-1 > N) {
				dp[i] = 0;
			//그 외에 i+일해야 하는 날짜부터 N 전까지 최대의 수익 가져와서 넣기
			} else {
				int max = Integer.MIN_VALUE;
				for(int j=i+date[i]; j<=N; j++) {
					max = Math.max(max, dp[j]);
				}
				dp[i] = value[i] + max;
			}
		}
		
		//수익 정렬
		Arrays.sort(dp);
		
		//가장 최대의 수익(dp[N]) 출력
		System.out.println(dp[N]);
		
		
	}//main

}
