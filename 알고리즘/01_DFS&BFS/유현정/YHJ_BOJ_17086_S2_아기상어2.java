package BOJ_17086_S2_아기상어2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		int[][] safeZone = new int[N][M];//안전거리 넣을 지도
		//델타탐색 방향
		int[] diri = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dirj = new int[] {1, 0, -1, 1, -1, 1, 0, -1};
		
		//지도 정보 넣기
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				map[i][j] = sc.nextInt();
				safeZone[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 1) {//상어 있는 곳에서 부터 시작
					safeZone[i][j] = 0; //상어 있으면 안전거리 0
					Queue<int[]> q = new LinkedList<>();
					int[] sarr = new int[] {i, j};
					q.add(sarr); //q에 상어 위치 넣고 시작
					
					int cnt = 0;
					//BFS
					while(!q.isEmpty()) {
						
						int sz = q.size(); //차원 카운트 용이하게 하기 위해 q사이즈 측정
						cnt++;
						for(int l = 0; l<sz; l++) {
							
							int[] st = q.poll();
							int si = st[0];
							int sj = st[1];
							
							for(int k = 0; k<diri.length; k++) {
								int ni = si+diri[k];
								int nj = sj+dirj[k];
								//범위 안에 있고, 상어 없고, 측정한 세이프거리가 현재 세이프거리보다 더 짧을 때
								if(0<=ni && ni<N && 0<=nj && nj<M && map[ni][nj] == 0 && safeZone[ni][nj]>cnt) {
										safeZone[ni][nj] = cnt;
										int[] tmp = new int[] {ni, nj};
										q.add(tmp);
								}
							}//k
						}//l
					}//while
				}
			}//j
		}//i
		
		int max = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(max<safeZone[i][j]) {
					max = safeZone[i][j];
				}
			}
		}
		
		System.out.println(max);
		
	}//main
	
}
