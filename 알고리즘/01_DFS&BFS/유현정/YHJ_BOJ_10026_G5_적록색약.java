package BOJ_10026_G5_적록색약;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[][] paint = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			String line = sc.nextLine();
			for(int j = 0; j<N; j++) {
				char a = line.charAt(j);
				if(a == 'R') {
					paint[i][j] = 1;
				}else if(a == 'G') {
					paint[i][j] = 4;
				}else {
					paint[i][j] = 2;
				}
			}
		}
		
		int n = 0;//실제 구역
		int b = 0;//적록색약 구역
		
		int[] diri = new int[] {0, 0, 1, -1};
		int[] dirj = new int[] {1, -1, 0, 0};
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		boolean[][] visited2 = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				//실제 구역 세기
				if(!visited[i][j]) {
					//BFS
					n++;
					q.add(i);
					q.add(j);
					visited[i][j] = true;
					while(!q.isEmpty()) {
						int x = q.poll();
						int y = q.poll();
						int color = paint[x][y];
				
						for(int k = 0; k<4; k++) {
							int nx = x+diri[k];
							int ny = y+dirj[k];
							//범위안에 있고, 같은 색이고, 방문 안 했으면 가기
							if(nx>=0 && nx<N && ny>=0 && ny<N && paint[nx][ny] == color && !visited[nx][ny]) {
								q.add(nx);
								q.add(ny);
								visited[nx][ny] = true;
							}
						}
					}//while
				}//n세기
				
				if(!visited2[i][j]) {
					b++;
					q2.add(i);
					q2.add(j);
					visited2[i][j] = true;
					while(!q2.isEmpty()) {
						int x = q2.poll();
						int y = q2.poll();
						int color = paint[x][y];
						
						
						for(int k = 0; k<4; k++) {
							int nx = x+diri[k];
							int ny = y+dirj[k];
							//범위안에 있고, 같은 색이고(r==g), 방문 안 했으면 가기
							if(nx>=0 && nx<N && ny>=0 && ny<N && !visited2[nx][ny] && paint[nx][ny]%3 == color%3) {
								q2.add(nx);
								q2.add(ny);
								visited2[nx][ny] = true;
							}
						}
					}
				}//b세기
				
			}//j
		}//i
		
		System.out.println(n+" "+b);
		
		
	}

}
