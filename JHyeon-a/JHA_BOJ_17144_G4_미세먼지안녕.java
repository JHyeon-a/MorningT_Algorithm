package BOJ_17144_G4_미세먼지안녕;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node{
		int r, c, value;

		public Node(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();		//R: 행의 크기
		int C = sc.nextInt();		//C: 열의 크기
		int T = sc.nextInt();		//T: 시간 (초)
		
		int[][] dust = new int[R][C];	//dust: 구사과 방
		
		int bottomR = 0;	//bottom: 아래의 공기청정기 행 (열은 항상 0)
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				dust[i][j] = sc.nextInt();
				
				//만약 -1이면 bootomR, -1이면 계속 갱신이 되니까
				if(dust[i][j] == -1) {
					bottomR = i;
				}
			}
		}
		//입력 끝
		
		int topR = bottomR-1;	//top: 위의 공기청정기 행 (열은 항상 0)
		
		Queue<Node> queue = new LinkedList<>();	//값을 넣을 queue
		
		// 상 하 좌 우(미세먼지 확산 돌릴 것)
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		//우 상 좌 하 (위 공기 청정기 돌릴 것)
		int[] dtopR = {0, -1, 0, 1};
		int[] dtopC = {1, 0, -1, 0};
		
		//우 하 좌 상 (아래 공기 청정기 돌릴 것)
		int[] dbottomR = {0, 1, 0, -1};
		int[] dbottomC = {1, 0, -1, 0};
		
		//t초만큼 돌린다.
		for(int t=0; t<T; t++) {
			
			//r, c 돌려서 5보다 크거나 같으면 queue에 넣고 (5 미만은 확산 X)
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					//5보다 크거나 같으면 queue에 넣기!
					if(dust[i][j] >=5) {
						queue.add(new Node(i, j, dust[i][j]));
					}
				}
			}
			
			//미세먼지 확산 시작
			while(!queue.isEmpty()) {
				Node e = queue.poll();
				
				//spread: 확산의 양
				int spread = e.value/5;
				int cnt = 0;
				
				//4방향 확인
				for(int d =0; d<4; d++) {
					int nr = e.r + dr[d];
					int nc = e.c + dc[d];
					//만약 범위 안에 있고 공기 청정기가 아니라면
					if(nr>=0 && nc>=0 && nr<R && nc<C && dust[nr][nc] != -1) {
						cnt++;
						dust[nr][nc] += spread;
					}
				}
				
				dust[e.r][e.c] = dust[e.r][e.c] - spread * cnt; 
				
			}
			
//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++) {
//					System.out.print(dust[i][j] + " ");
//				}
//				System.out.println();
//			}
//			
//			System.out.println();
			
			
			//공기 청정기 작동 시작
			//1. 윗 부분
			
			int d = 0;
			
			int x = topR;	//x: 현재 위치 x
			int y = 1;		//y: 현재 위치 y
			
			int tmp = 0;	//tmp: 이번 방문에 넣을 값
			int value = 0;	//value: 다음 방문(좌표)에 넣을 값
			
			while(true) {
				int nr = x + dtopR[d];
				int nc = y + dtopC[d];
				
				value = dust[x][y];
				dust[x][y] = tmp;
			
				if(nr<0 || nc<0 || nr>=R || nc>=C) {
					d = (d+1)%4;
					nr = x + dtopR[d];
					nc = y + dtopC[d];
				}
				
				tmp = value;
//				dust[nr][nc] = value;	//dust[nr][nc] = 2;
				
				if(nr == topR-1 && nc==0) {
					dust[nr][nc] = value;
					break;
				}
				
				
				x = nr;
				y = nc;
				
			}
			
//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++) {
//					System.out.print(dust[i][j] + " ");
//				}
//				System.out.println();
//			}
//			
//			System.out.println();
			
			//2. 아래 부분
			
			d = 0;
			
			x = bottomR;
			y = 1;
			
			tmp =0;
			value = 0;
			
			while(true) {
				int nr = x + dbottomR[d];
				int nc = y + dbottomC[d];
				
				value = dust[x][y];
				dust[x][y] = tmp;
				
				if(nr<0 || nc<0 || nr>=R || nc>=C) {
					d = (d+1)%4;
					nr = x + dbottomR[d];
					nc = y + dbottomC[d];
				}
				
				tmp = value;
				
				if(nr == bottomR+1 && nc==0) {
					dust[nr][nc] = value;
					break;
				}
				
				x = nr;
				y = nc;
				
			}
			
//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++) {
//					System.out.print(dust[i][j] + " ");
//				}
//				System.out.println();
//			}
//			
//			System.out.println();
			
		}
		
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sum += dust[i][j];
			}
		}
		
		System.out.println(sum+2);
		
	}//main

}
