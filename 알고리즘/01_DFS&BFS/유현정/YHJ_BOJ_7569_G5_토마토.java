package BOJ_7569_토마토_G5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		
		int[][][] str = new int[H][N][M];
		Queue<Integer> q = new LinkedList<>();
		int num = 0; //0개수
		
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<M; k++) {
					str[i][j][k] = sc.nextInt();
					if(str[i][j][k] == 1) {
						q.add(i);
						q.add(j);
						q.add(k);
					}
					if(str[i][j][k] == 0) num++;
				}
			}
		}
		
		//1-익음. -1 없음. 0-안 익음
		//BFS탐색
		int cnt = 0;
		int[] diri = new int[] {1, -1, 0, 0, 0, 0};
		int[] dirj = new int[] {0, 0, 0, 0, -1, 1};
		int[] dirk = new int[] {0, 0, 1, -1, 0, 0};
		
		while(!q.isEmpty()) {
			int size = q.size()/3;
			for(int l = 0; l<size; l++) {
				int i = q.poll();
				int j = q.poll();
				int k = q.poll();
				
				for(int m = 0; m<6; m++) {
					int ni = i+diri[m];
					int nj = j+dirj[m];
					int nk = k+dirk[m];
					if(ni>=0 && ni<H && nj>=0 && nj<N && nk>=0 &&nk<M && str[ni][nj][nk] == 0) {
						q.add(ni);
						q.add(nj);
						q.add(nk);
						str[ni][nj][nk] = 1;
						num--;
					}
				}
			}//l
			cnt++;
			
		}
		if(num == 0) {
			System.out.println(cnt-1); //넣었다 빼는 것 만으로도 1개 더하니까
		}else {
			System.out.println(-1);
		}
		
		
		
	}
}
