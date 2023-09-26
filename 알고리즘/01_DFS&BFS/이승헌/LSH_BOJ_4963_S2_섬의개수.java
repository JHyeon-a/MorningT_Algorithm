package BOJ_4963_S2_섬의개수;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			
			int w = sc.nextInt(); // 지도의 너비
			int h = sc.nextInt(); // 지도의 높이
			
			if(w==0 && h==0) break;

			int[][] map = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
			int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

			Queue<int[]> queue = new LinkedList<>();

			int cnt = 0; // 섬개수
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {

					if (map[i][j] == 1) {
						queue.add(new int[] { i, j });
						cnt++;
					}

					// bfs
					while (!queue.isEmpty()) {
						int[] p = queue.poll();
						map[p[0]][p[1]] = 0;
						for (int k = 0; k < 8; k++) {
							int nr = p[0] + dr[k];
							int nc = p[1] + dc[k];

							if (nr >= 0 && nc >= 0 && nr < h && nc < w && map[nr][nc] == 1) {
								queue.add(new int[] { nr, nc });
								map[nr][nc] = 0;
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
