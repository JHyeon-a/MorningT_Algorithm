package BOJ_2096_G5_내려가기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//N: 몇 줄인지
		int[][] arr = new int[N][3];	//arr: 원본
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//입력 받기
		
		int[][] dpMax = new int[N][3];		//dpMax[i][j]: dpMax[i][j]에서 가질 수 있는 최대값
		int[][] dpMin = new int[N][3];		//dpMin[i][j]: dpMin[i][j]에서 가질 수 있는 최대값
		
		//dpMax와 dpMin의 0행 설정
		for(int j=0; j<3; j++) {
			dpMax[0][j] = arr[0][j];
			dpMin[0][j] = arr[0][j];
		}
		
		//1행부터 N-1행까지 실행
		for(int i=1; i<N; i++) {
			
			//맨 왼쪽 (0열)은 바로 위랑 바로 위의 오른쪽만 가능
			dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]);
			dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]);
			
			//맨 오른쪽 (2열)은 바로 위랑 바로 위의 왼쪽만 가능
			dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]);
			dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]);
			
			//가운데(1열)은 바로 위의 왼쪽 오른쪽 다 가능 => 자신의 왼쪽 오른쪽 중에 큰 값을 가져오면 됨.
			dpMax[i][1] = Math.max(dpMax[i][0], dpMax[i][2]);
			dpMin[i][1] = Math.min(dpMin[i][0], dpMin[i][2]);
			
			//가장 최대를 가져왔으면 거기에 현재 자기 자신 더하기
			dpMax[i][0] += arr[i][0];
			dpMax[i][1] += arr[i][1];
			dpMax[i][2] += arr[i][2];
			
			//가장 최소를 가져왔으면 거기에 현재 자기 자신 더하기
			dpMin[i][0] += arr[i][0];
			dpMin[i][1] += arr[i][1];
			dpMin[i][2] += arr[i][2];
			
		}
		
		int resultMax =0;
		int resultMin = Integer.MAX_VALUE;
		
		//resultMax, resultMin: 최대값, 최소값
		for(int j=0; j<3; j++) {
			resultMax = Math.max(resultMax, dpMax[N-1][j]);
			resultMin = Math.min(resultMin, dpMin[N-1][j]);
		}
		
		System.out.println(resultMax + " " + resultMin);
		
	}//main

}
