package boj_내려가기_G5_2096;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력
		int N = sc.nextInt();
		int[][] num = new int[N][3];
		int[][] max = new int[N][3];
		int[][] min = new int[N][3];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<3; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		
		//dp
		for(int j = 0; j<3; j++) {
			max[0][j] = num[0][j];
			min[0][j] = num[0][j];
		}
		for(int i = 1; i<N; i++) {
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + num[i][0];
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + num[i][0];
			
			max[i][1] = Math.max(max[i-1][2], Math.max(max[i-1][0], max[i-1][1])) + num[i][1];
			min[i][1] = Math.min(min[i-1][2], Math.min(min[i-1][0], min[i-1][1])) + num[i][1];
			
			max[i][2] = Math.max(max[i-1][2], max[i-1][1]) + num[i][2];
			min[i][2] = Math.min(min[i-1][2], min[i-1][1]) + num[i][2];
		}//i
		
		//누적 최댓값, 최솟값 찾기
		int big = Math.max(max[N-1][2], Math.max(max[N-1][0], max[N-1][1]));
		int small = Math.min(min[N-1][2], Math.min(min[N-1][0], min[N-1][1]));

		//출력
		System.out.println(big+" "+small);
	}

}
