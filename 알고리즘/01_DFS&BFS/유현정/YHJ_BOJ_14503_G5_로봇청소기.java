package BOJ_14503_G5_로봇청소기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] room;
	static int cnt;
	static int[] diri;
	static int[] dirj;
	static int N;
	static int M;
	static int d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		room = new int[N][M];
		int r = sc.nextInt();//현 위치
		int c = sc.nextInt();
		d = sc.nextInt(); //현 방향
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				room[i][j] = sc.nextInt(); //방 상태
			}
		}
		
		cnt = 0; //청소한 칸 개수
		diri = new int[]{-1, 0, 1, 0};
		dirj = new int[]{0, 1, 0, -1};
		
		DFS(r, c);
		
	}
	
	public static void DFS(int r, int c) {
		//청소 안 된 칸 청소
		if(room[r][c] == 0) {
			cnt++;
			room[r][c] = 2;
		}
		//주변에 청소할 칸 찾기
		int tmp = 0;
		for(int i = 0; i<4; i++) {
			int nr = r+diri[i];
			int nc = c+dirj[i];
			if(nr>=0 && nr<N && nc>=0 && nc<M && room[nr][nc] == 0) {
				tmp++;
				break;
			}
		}
		//청소할 칸 있으면
		if(tmp>0) {
			for(int i = 0; i<4; i++) {
				d = d-1;
				if(d<0) d += 4;
				int nr = r+diri[d];
				int nc = c+dirj[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M && room[nr][nc] == 0) {
					DFS(nr, nc);
					break;
				}
			}
		}else {
			int tmpdir = d-2;
			if(tmpdir<0) tmpdir+= 4;
			int nr = r+diri[tmpdir];
			int nc = c+dirj[tmpdir];
			if(nr>=0 && nr<N && nc>=0 && nc<M && room[nr][nc] != 1) {
				DFS(nr, nc);
			}else {
				System.out.println(cnt);
			}
		}
	}//dfs

}
