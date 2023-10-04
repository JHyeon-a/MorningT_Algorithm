package BOJ_2468_S1_안전영역;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node{
		int r;
		int c;
		public node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();					//N: 지역 크기
		int[][] map = new int[N][N];			//map: 지역
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		Queue<node> queue = new LinkedList<>();
		
		int max = 0;
		int min = 101;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}//map
		
		int result = 1;	//result: 안전한 영역 최대 개수
		
		//bfs 시작
		for(int m=min; m<max+1; m++) {			
			int cnt = 0;	//덩어리 개수 찾기
			boolean[][] visited = new boolean[N][N];//visited: 방문체크용
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j] || map[i][j] <=m)
						continue;
					
					cnt++;
					queue.add(new node(i, j));
					while(!queue.isEmpty()) {
						node e = queue.poll();
						
						for(int d=0; d<4; d++) {
							int nr = e.r + dr[d];
							int nc = e.c + dc[d];
							
							if(nr>=0 && nc>=0 && nr<N && nc<N && !visited[nr][nc] && map[nr][nc]>m) {
								queue.add(new node(nr, nc));
								visited[nr][nc] = true;
							}
							
							
						}
						
						
					}//while (bfs)
					
					
					
				}//j
			}//i
			
			result = Math.max(result, cnt);
		}
		
		
		System.out.println(result);
		
	}//main

}//Main Class
