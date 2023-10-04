package BOJ_2178_S1_미로탐색;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		int N = Integer.parseInt(tmp.split(" ")[0]);
		int M = Integer.parseInt(tmp.split(" ")[1]);
		
		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			String line = sc.nextLine();
			for(int j = 0; j<M; j++) {
				arr[i][j] = Character.getNumericValue(line.charAt(j));
				if(arr[i][j] == 1) {
					visited[i][j] = true;
				}
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(0);
		int[] diri = new int[] {0, 0, 1, -1};
		int[] dirj = new int[] {-1, 1, 0, 0};
		int cnt = 0;
		visited[0][0] = false;
		
		loop1: while(!q.isEmpty()) {
			int size = q.size()/2;
			for(int l = 0; l<size; l++) {
				int i = q.poll();
				int j = q.poll();
				if(i == N-1 && j == M-1) {
					System.out.println(cnt+1);
					break loop1;
				}//if
				
				for(int k = 0; k<4; k++) {
					int ni = i+diri[k];
					int nj = j+dirj[k];
					if(ni>=0 && ni<N &&nj>=0 &&nj<M && visited[ni][nj]) {
						visited[ni][nj] = false;
						q.add(ni);
						q.add(nj);
					}//if
				}//k
			}//l
			cnt++;
			
		}//while
		
	}

}
