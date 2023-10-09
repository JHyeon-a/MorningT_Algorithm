package BOJ_17144_G4_미세먼지안녕;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int t = sc.nextInt();
		
		int[][] room = new int[r][c];
		
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				room[i][j] = sc.nextInt();
			}
		}
		
		//공기청정기 찾기
		int up = 0;
		for(int i = 0; i<r; i++) {
			if(room[i][0] == -1) {
				up = i;
				break;
			}
		}
		
		//t초만큼 확산과 이동 반복
		int[] diri = new int[] {0, 0, 1, -1};
		int[] dirj = new int[] {1, -1, 0, 0};
		for(int T = 0; T<t; T++) {
			//확산
			//확산량 측정
			//확산량 담아 놓을 배열
			int[][] tmp = new int[r][c];
			
			for(int i = 0; i<r; i++) {
				for(int j = 0; j<c; j++) {
					//미세먼지 있으면
					if(room[i][j]>0) {
						int diffusion = room[i][j]/5;
						for(int k = 0; k<4; k++) {
							int ni = i+diri[k];
							int nj = j+dirj[k];
							//델타탐색, room범위 안에 있고, 공기청정기 아니면
							if(ni>=0 && ni<r && nj>=0 && nj<c && room[ni][nj]!= -1) {
								tmp[ni][nj] += diffusion;
								tmp[i][j] -= diffusion;
							}
						}
					}
				}//j
			}//i
			//확산
			for(int i = 0; i<r; i++) {
				for(int j = 0; j<c; j++) {
					room[i][j] += tmp[i][j];
				}
			}
			
			//이동
			//윗 부분-반시계로 돌음, 들어오는 방향으로 할 것-시계(tmp만들어서 남는 거 따로 저장 안 해도 되게)
			//위에서 내려오는 먼지
			for(int i = up-2; i>=0; i--) {
				room[i+1][0] = room[i][0];
			}
			//아래
			for(int i = up+3; i<r; i++) {
				room[i-1][0] = room[i][0];
			}
			//맨 위와 아래의 오른쪽에서 왼쪽으로 오는 먼지
			for(int j = 1; j<c; j++) {
				room[0][j-1] = room[0][j];
				room[r-1][j-1] = room[r-1][j];
			}
			//가장 오른쪽 열의 아래에서 올라오는 먼지
			for(int i = 1; i<=up; i++) {
				room[i-1][c-1] = room[i][c-1];
			}
			for(int i = r-2; i>up; i--) {
				room[i+1][c-1] = room[i][c-1];
			}
			//왼쪽에서 오른쪽으로 가는 먼지
			for(int j = c-2; j>0; j--) {
				room[up][j+1] = room[up][j]; 
				room[up+1][j+1] = room[up+1][j];
			}
			room[up][1] = 0;
			room[up+1][1] = 0;
		}
		
		//남은 먼지 세기
		int cnt = 0;
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				cnt+= room[i][j];
			}
		}
		System.out.println((cnt+2));
		
		
	}//main

}
