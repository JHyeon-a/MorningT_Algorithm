package BOJ_2178_S1_미로탐색;

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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] miro = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				miro[i][j] = str.charAt(j)-'0';
			}
		}
		
		//상 하 좌 우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(new Node(0, 0));
		
		
		while(!queue.isEmpty()) {
			Node e = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = e.r + dr[d];
				int nc = e.c + dc[d];
				
				if(nr>=0 && nc>=0 && nr<N && nc<M && miro[nr][nc] == 1) {
					miro[nr][nc] = miro[e.r][e.c]+1;
					queue.add(new Node(nr, nc));
				}
				
			}
		}
		
		System.out.println(miro[N-1][M-1]);
		
		
	}//main

}
