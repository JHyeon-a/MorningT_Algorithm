package BOJ_10026_G5_적록색약;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Node{
		int r, c;
		char color;

		public Node(int r, int c, char color) {
			super();
			this.r = r;
			this.c = c;
			this.color = color;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());	//N: 크기
		char[][] arr = new char[N][N];				//arr: 그리드 칸 배열
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j);
			}
		} //입력 끝
		
		//상 하 좌 우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};

		//적록색약 아닌 사람의 버전
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];	//visited: 방문체크
		int cnt =0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(visited[i][j])
					continue;
				
				cnt++;
				queue.add(new Node(i, j, arr[i][j]));
				
				while(!queue.isEmpty()) {
					Node e = queue.poll();
					
					if(visited[e.r][e.c])
						continue;
					
					visited[e.r][e.c] = true;
					
					for(int d=0; d<4; d++) {
						int nr = e.r +dr[d];
						int nc = e.c + dc[d];
						
						if(nr>=0 && nc>=0 && nr<N && nc<N && arr[nr][nc] == e.color) {
							queue.add(new Node(nr, nc, arr[nr][nc]));
						}
						
						
					}//델타 for문
					
				}//while
				
			}//j
		}//i
		
		//적록색약 버전
		Queue<Node> queue2 = new LinkedList<>();
		boolean[][] visited2 = new boolean[N][N];
		int cnt2 = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(visited2[i][j])
					continue;
				
				cnt2++;
				queue2.add(new Node(i, j, arr[i][j]));
				
				while(!queue2.isEmpty()) {
					Node e = queue2.poll();
					
					if(visited2[e.r][e.c])
						continue;
					
					visited2[e.r][e.c] = true;
					
					
					for(int d=0; d<4; d++) {
						int nr = e.r +dr[d];
						int nc = e.c + dc[d];
						
						if(nr>=0 && nc>=0 && nr<N && nc<N) {
							switch (e.color) {
							case 'R':
								if(arr[nr][nc] == 'R' || arr[nr][nc] == 'G')
									queue2.add(new Node(nr, nc, arr[nr][nc]));
								break;
							
							case 'G':
								if(arr[nr][nc] == 'R' || arr[nr][nc] == 'G')
									queue2.add(new Node(nr, nc, arr[nr][nc]));
								break;

							case 'B':
								if(arr[nr][nc] == 'B')
									queue2.add(new Node(nr, nc, arr[nr][nc]));
								
								break;
							}
					
						}
						
						
					}//델타 for문
					
				}//while
				
			}//j
		}//i
		
		System.out.println(cnt + " " + cnt2);
		
	}//main

}
