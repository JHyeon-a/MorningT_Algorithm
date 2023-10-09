package BOJ_21610_G5_마법사상어와비바라기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node{
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	static int[] dr2 = {-1, -1, 1, 1};
	static int[] dc2 = {-1, 1, 1, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//N: 격자 크기
		int M = sc.nextInt();	//M: 명령 개수
		
		int[][] map = new int[N][N];	//map: 격자
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(N-1, 0));
		queue.add(new Node(N-1, 1));
		queue.add(new Node(N-2, 0));
		queue.add(new Node(N-2, 1));
		
		
		for(int m=0; m<M; m++) {
			
			boolean[][] visited = new boolean[N][N];	//visited 방문체크
			
			int direction = sc.nextInt()-1;	//direction 방향 입력 받고
			int move = sc.nextInt();		//move: 이동 입력 받고
			
			int qs = queue.size();
			//비구름 생성 후 +1
			for(int i=0; i<qs; i++) {
				Node e = queue.poll();
				
				int nr = e.r + dr[direction] * move;
				int nc = e.c + dc[direction] * move;
			
				
				if(nr<0) {
					e.r = (N + nr%N)%N;
				} else {
					e.r = nr%N;
				}
				
				if(nc<0) {
					e.c = (N + nc%N)%N;
				} else {
					e.c = nc%N;
				}
				map[e.r][e.c]++;
				visited[e.r][e.c] = true;
				queue.add(new Node(e.r, e.c));
				
			
			}

			qs = queue.size();
			//물복사 버그 마법
			for(int i=0; i<qs; i++) {
				Node e = queue.poll();
				int cnt =0;
				for(int d=0; d<4; d++) {
					int nr = e.r + dr2[d];
					int nc = e.c + dc2[d];
					
					if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc]!=0) {
						cnt++;
					}

				}
				map[e.r][e.c] +=cnt;
			}
			
			//바구니에 저장된 물의 양이 2이상인 모든 칸의 물의 양이 2 줄어 든다.
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>=2 && !visited[i][j]) {
						map[i][j] -= 2;
						queue.add(new Node(i, j));
					}
				}
			}
			
		}
		
		int sum =0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
		
		
	}//main

}
