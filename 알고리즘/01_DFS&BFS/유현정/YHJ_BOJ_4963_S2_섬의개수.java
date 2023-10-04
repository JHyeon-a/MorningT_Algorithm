package BOJ_4963_S2_섬의개수;

import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[] diri = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dirj = new int[] {-1, 0, 1, 1, -1, -1, 0, 1};
	static boolean[][] visited;
	static int w;
	static int h;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0; i<h; i++) {
				for(int j = 0; j<w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			for(int i = 0; i<h; i++) {
				for(int j = 0; j<w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						DFS(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
			
			
		}//while
		
		//백준- 동전 거스름돈, 배낭 , 2839(설탕 배달?), 서술형-점화식, 시간 복잡도 계산, ??
		//주석달기 - 어떻게 사고했는지도 적기
		
		
	}//main
	
	//섬 1개씩 방문하기
	public static void DFS(int i, int j) {
		visited[i][j] = true;
		
		for(int k = 0; k<diri.length; k++) {
			int ni = i+diri[k];
			int nj = j+dirj[k];
			
			//범위 안에 들고, visited 안 했고, 섬(1)인 부분
			if(0 <= ni && 0<= nj && ni< h && nj<w && !visited[ni][nj] && map[ni][nj] == 1) {
				DFS(ni, nj);
			}
		}
		
		
	}//DFS

}
