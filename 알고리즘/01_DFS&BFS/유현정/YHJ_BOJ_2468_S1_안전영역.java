package BOJ_2468_S1_안전영역;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int max = 0;
		int[] diri = new int[] {0, 0, 1, -1};
		int[] dirj = new int[] {-1, 1, 0, 0};
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				arr[i][j] = sc.nextInt();
				if(max<arr[i][j]) max = arr[i][j];
			}
		}
		
		int result = 1;
		int h = 1;
		Queue<Integer> q = new LinkedList<>();
		while(h<=max) {
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(arr[i][j]>h) {
						visited[i][j] = true; //갈 곳 바꾸기
					}
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(visited[i][j]) {
						cnt++;
						visited[i][j] = false;
						q.add(i);
						q.add(j);
						
						while(!q.isEmpty()) {
							int ni = q.poll();
							int nj = q.poll();
							
							for(int k = 0; k<4; k++) {
								int newi = ni+diri[k];
								int newj = nj+dirj[k];
								if(newi>=0 && newi<N && newj>=0 && newj<N && visited[newi][newj]) {
									q.add(newi);
									q.add(newj);
									visited[newi][newj] = false;
								}
							}
						}//q
						
					}//if
					
				}
			}
			if(cnt>result) result = cnt;
			h++;
		}//h
		
		System.out.println(result);
		
		
	}

}
