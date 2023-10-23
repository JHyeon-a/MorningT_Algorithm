 package BOJ_2579_S3_계단오르기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stairNum = sc.nextInt();			//stairNum: 계단의 개수
		int[] stair = new int[stairNum+1];		//stair[]: 계단에 적힌 점수 배열
		int[] dp = new int[301];				//dp[]: 각 칸의 최대 점수를 저장한 dp 배열
		
		for(int i=1; i<=stairNum; i++) {
			stair[i] = sc.nextInt();
		}
		
		
		dp[stairNum] = stair[stairNum];			//맨 뒤의 값 저장
		
		
		//뒤에서부터 dp를 시작할 것이다.
		for(int i=stairNum-1; i>0; i--) {
			//맨 뒤에서 2, 3번째 값은 따로 설정
			if(i == stairNum-1 || i== stairNum-2) {
				dp[i] = dp[stairNum];
			//그 외는 i 전 계단을 밟았을 때의 값(dp[i+3] + stair[i+1])과 2 계단 전의 계단을 밟았을 때의 값(dp[i+2]) 큰 값을 가져옴
			} else {
				dp[i] = Math.max(dp[i+3]+stair[i+1], dp[i+2]);
			}
			
			//현재의 계단 점수 더해주기
			dp[i] += stair[i];
			
		}
		
		//첫 번째 계단을 밟고 시작하거나 두 번째 계단을 밟고 시작해야 하기 때문에 둘 중 더 큰 값을 가져온다.
		System.out.println(Math.max(dp[1], dp[2]));
		
	}//main

}
