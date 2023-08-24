package BOJ_2865_슈퍼스타K_S4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		//N: 참가자수
		int M = sc.nextInt();		//M: 오디션 장르 수
		int K = sc.nextInt();		//K: 본선 진출 가능한 사람 수
		double[] arr = new double[N + 1];	//점수 계속 받아서 담아두는 곳
											//count 함수처럼 사용하기 위해 N+1크기만큼 만들기
		double[] max = new double[N + 1];	//각 참가자들의 가장 최고 점수 저장하는 배열

		for (int i = 0; i < M; i++) {				//M번 돌면서
			for (int j = 0; j < N; j++) {			//N만큼 받을 것.
				int tmp = sc.nextInt();					//번호 입력 받고
				arr[tmp] = sc.nextDouble();				//점수 입력 받고
				max[tmp] = Math.max(arr[tmp], max[tmp]);	// 입력 받은 점수가  max[tmp]보다 크면 max[tmp] 갱신

			} // j만큼 받을 건데
		} // M만큼 돌면서

		Arrays.sort(max);		//오름차순 정렬

		double sum = 0;			//sum: 본선 진출자의 점수합
		
		//뒤에서부터 K번 가져와서 더할 것. (오름차순이니까 가장 높은 점수는 뒤에 있다.)
		for (int i = max.length - 1; i > max.length - 1 - K; i--) {
			sum += max[i];		//가져온 값을 sum에 저장
		}

		//출력 (소수 첫째자리까지 반올림하기 위해서 sum*10한 것을 round 함수로 감싸고 이걸 10.0으로 나눈다.
		System.out.println(Math.round(sum * 10) / 10.0);

	}// main

}// MainClass
