package BOJ_15649_N과M_1_S3;

import java.util.Scanner;

public class Main {
	public static int N;			//N: 몇 개의 숫자를 돌릴 건지(1부터 N까지의 숫자)
	public static int M;			//M: 몇 개로 나타낼 건지
	public static int[] nums;		//nums: 숫자 담아두는 배열
	public static int[] result;		//result: 순열 돌린 숫자들을 담아두고 나타내기 위한 배열
	public static boolean[] check;	//check: 썼는지 안 썼는지 확인하는
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		result = new int[M];
		check = new boolean[N];
		
		for(int n=1; n<=N; n++) {
			nums[n-1] = n;
		}	//nums[0] = 1, nums[1]=2, ...
		
		parm(0);	//순열 만드는 재귀 함수 돌리기
		
	}//main
	
	//idx: result의 인덱스
	public static void parm(int idx) {
		if(idx == M) {	//result에 순열 다 담으면
			//담은 거 다 출력
			for(int i=0; i<M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//재귀 부분
		for(int i=0; i< N; i++) {
			//방문한 곳이면 다음 곳으로 넘어가고
			if(check[i]) {
				continue;
			}
			
			//방문한 곳이 아니라면
			//result에 넣고
			result[idx] = nums[i];
			check[i] = true;	//방문한 곳 체크
			parm(idx+1);		//다음 재귀
			check[i] = false;	//방문한 곳 다시 해제
		}
	}

}//Main
