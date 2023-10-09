package BOJ_12100_G2_2048;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int result = 2;
	static int[] route;
	static int max = 2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int[][] board = new int[N][N];
		
		result = 0;
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j]>max) max = board[i][j];
			}
		}

		//4방향으로 5번 움직이는 DFS 할 것
		//result값 갱신하고, result/2^남은 횟수가 그 판의 max보다 작으면 안 감 
		DFS(board);
		System.out.println(result);
		
	}
	static int cnt = 0;
	
	public static void DFS(int[][] B) {
		if(cnt>4) {
			if(max>result) result = max;
			return;
		}
		//가망 없는 애들>남은 라운드 모두 2배씩해도 안 됨
		if(result/Math.pow(2, 5-cnt)>=max) {
			return;
		}
		
		int[][] temp = new int[N][N];
		copy(temp, B);
		
		for(int i = 1; i<=4; i++) {
			switch(i) {
			case 1:
				DFS(collision(1, 0, B));
				copy(B, temp);
				cnt--;
				break;
			case 2:
				DFS(collision(-1, 0, B));
				copy(B, temp);
				cnt--;
				break;
			case 3:		
				DFS(collision(0, -1, B));
				copy(B, temp);
				cnt--;
				break;
			case 4:
				DFS(collision(0, 1, B));
				copy(B, temp);
				cnt--;
				break;
			}
		}
	}//DFS
	
	public static void copy(int[][] temp, int[][] B) {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				temp[i][j] = B[i][j];
			}
		}
	}
	
	//방향에 따른 충돌-위(1, 0) 아(-1, 0) 오(0, -1) 왼(0, 1)
	public static int[][] collision(int d1, int d2, int[][] B2) {
		max = 0;
		cnt++;
		//이동
		if(d1+d2>0) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(B2[i][j] == 0) {
						for(int k = 1; k<N; k++) {
							int ni = i+k*d1;
							int nj = j+k*d2;
							if(ni>=0 && ni<N && nj>=0 && nj<N && B2[ni][nj] !=0) {
								B2[i][j] = B2[ni][nj];
								B2[ni][nj] = 0;
								break;
							}
						}
					}
				}
			}
		}else {
			for(int i = N-1; i>=0; i--) {
				for(int j = N-1; j>=0; j--) {
					if(B2[i][j] == 0) {
						for(int k = 1; k<N; k++) {
							int ni = i+k*d1;
							int nj = j+k*d2;
							if(ni>=0 && ni<N && nj>=0 && nj<N && B2[ni][nj] !=0) {
								B2[i][j] = B2[ni][nj];
								B2[ni][nj] = 0;
								break;
							}
						}
					}
				}
			}
		}

		//합치기
		//위는 위에서부터, 아래는 아레에서부터, 오른쪽 오른쪽부터, 왼쪽 왼쪽부터
		//위, 왼쪽
		if(d1+d2>0) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					int ni = i+d1;
					int nj = j+d2;
					if(ni>=0 && ni<N && nj>=0 && nj<N && B2[i][j] == B2[ni][nj]) {
						B2[i][j] *= 2;
						B2[ni][nj] = 0;
					}
				}
			}
			//아래, 오른쪽
		}else {
			for(int i = N-1; i>=0; i--) {
				for(int j = N-1; j>=0; j--) {
					int ni = i+d1;
					int nj = j+d2;
					if(ni>=0 && ni<N && nj>=0 && nj<N && B2[i][j] == B2[ni][nj]) {
						B2[i][j] *= 2;
						B2[ni][nj] = 0;
					}
				}
			}
		}
		
		//이동
		if(d1+d2>0) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(B2[i][j] == 0) {
						for(int k = 1; k<N; k++) {
							int ni = i+k*d1;
							int nj = j+k*d2;
							if(ni>=0 && ni<N && nj>=0 && nj<N && B2[ni][nj] !=0) {
								B2[i][j] = B2[ni][nj];
								B2[ni][nj] = 0;
								break;
							}
						}
					}
					if(max<B2[i][j]) max = B2[i][j];
				}
			}
		}else {
			for(int i = N-1; i>=0; i--) {
				for(int j = N-1; j>=0; j--) {
					if(B2[i][j] == 0) {
						for(int k = 1; k<N; k++) {
							int ni = i+k*d1;
							int nj = j+k*d2;
							if(ni>=0 && ni<N && nj>=0 && nj<N && B2[ni][nj] !=0) {
								B2[i][j] = B2[ni][nj];
								B2[ni][nj] = 0;
								break;
							}
						}
					}
					if(max<B2[i][j]) max = B2[i][j];
				}
			}
		}
		return B2;
	}//collision
}

