package BOJ_7576_G5_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//BFS로 풀기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] str = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		int total = 0;
		int sum = 0;
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				str[i][j] = sc.nextInt();
				if(str[i][j] == 0) {
					total++;
				}else if(str[i][j] == 1) {
					int[] tmp = new int[] {i,j};
					visited[i][j] = true;
					q.add(tmp);
					total++;
				}
			}
		}
		
		int[] diri = new int[]{1, -1, 0, 0};
		int[] dirj = new int[]{0, 0, 1, -1};
		//BFS
		int cnt = 0;
		while(!q.isEmpty()) {
			
			int size = q.size();
			for(int l = 0; l<size; l++) {
				
				int[] pos = q.poll();
				sum++;
				int i = pos[0];
				int j = pos[1];
				
				
				for(int k = 0; k<4; k++) {
					int ni = i+diri[k];
					int nj = j+dirj[k];
					
					if(0<=ni && ni<N && 0<=nj && nj<M && !visited[ni][nj] && str[ni][nj] == 0) {
						int[] tmp = new int[] {ni, nj};
						visited[ni][nj] = true;
						q.add(tmp);
					}
				}
			}//l
			cnt++;
		}
		
		if(sum == total) {
			System.out.println(cnt-1);
		}else {
			System.out.println(-1);
		}
		
	}

}
