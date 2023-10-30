package BOJ_9663_NQueen;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static int[] board;
	static int N;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		board = new int[N];//board[i] = j > i행, j열 
		DFS(0);
		System.out.println(cnt);
	}

	public static void DFS(int i) {
		if(i == N) {
			cnt++;
			return;
		}
		//return 조건
		//마지막 행(cnt++), 0이 아닌 곳
		
		//1. 세로, 우하향, 좌하향 체크하기
		//2. 놓으면 다음 행으로 넘어가기
		
		//세로, 대각선 체크
		for(int j = 0; j<N; j++) {
			if(check(i, j)) {
				board[i] = j;
				DFS(i+1);
			}
		}
	}//dfs

	
	public static boolean check(int i, int j) {
		for(int r = 0; r<i; r++) {
			if(board[r] == j||board[r]+j == i+j||board[r]-j == i-j) {//세로 체크, 우하향, 좌하향
				return false;
			}
		}
		return true;
	}
	
}
