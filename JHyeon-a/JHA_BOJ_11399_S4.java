package BOJ_11399_ATM_S4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 줄 서 있는 사람 수 N과
 * 각 사람이 돈을 인출하는데 걸리는 시간 P(배열)이 주어졌을 때,
 * 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값 구하기
 * (접근: 정렬)
 */

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//N: ATM기 앞에 서 있는 사람 수
		int[] P = new int[N];	//P: 각 사람이 돈을 인출하는데 걸리는 시간 배열
		
		for(int i=0; i<N; i++) {
			P[i] = sc.nextInt();
		}	//P 배열 입력 끝
		
		Arrays.sort(P);	//시간 오름차순 정렬
		
		int sum =P[0];		//결과로 나올 최소값 합 (인덱스 0은 누적합 배열 의미 없어서 뺄 거니 sum에 P[0] 넣어두기
		//P 배열을 누적합 배열로 만들기
		for(int i=1; i<N; i++) {
			P[i] += P[i-1];	
			sum += P[i];	//새로 만든 누적합 배열을 sum에 넣기
		}
		
		System.out.println(sum);
		
		
		
	}//main

}//Class Main
