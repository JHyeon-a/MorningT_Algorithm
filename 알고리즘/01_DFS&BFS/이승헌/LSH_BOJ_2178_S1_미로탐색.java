package BOJ_2178_S1_미로탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // row
		int M = sc.nextInt(); // column

		// miro 생성 -> 1,1에서 시작하니까 0번 r,c를 그냥 0으로 채우면됨
		int[][] miro = new int[N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			String S = sc.next();
			for (int j = 0; j < M; j++) {
				miro[i + 1][j + 1] = Integer.parseInt(S.split("")[j]);
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N + 1][M + 1];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		// 첫째칸에서 이미 한번 움직인걸로 친다
		int move = 1;

		queue.add(new int[] { 1, 1 });

		// bfs
		loop1:while (!queue.isEmpty()) {
			int q_size = queue.size();
			for(int i=0;i<q_size;i++) {
				int[] p = queue.poll();
				
				visited[p[0]][p[1]] = true;
				
				for(int k=0;k<4;k++) {
					int nr = p[0] + dr[k];
					int nc = p[1] + dc[k];
					
					if(nr > 0 && nc > 0 && nr <= N && nc <= M && miro[nr][nc] == 1 && !visited[nr][nc]) {
						queue.add(new int[] {nr,nc});
						visited[nr][nc] = true;
						
						if(nr == N && nc == M) {
							move++; // while문이 깨지면서 마지막 move는 안들어감
							break loop1;
						}
					}
				}
			}
			move++;
		}
		System.out.println(move);
	}
}
