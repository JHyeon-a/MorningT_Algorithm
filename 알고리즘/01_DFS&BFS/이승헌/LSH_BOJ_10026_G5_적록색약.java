package BOJ_10026_G5_적록색약;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 그리드의 한 변
		String[][] grid = new String[N][N];

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				grid[i][j] = s.split("")[j];
			}
		}

		// 일반인
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		// 적록색약인
		Queue<int[]> queue_rg = new LinkedList<>();
		boolean[][] visited_rg = new boolean[N][N];

		int cnt = 0, cnt_rg = 0;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!visited[i][j]) {
					queue.add(new int[] { i, j });
					cnt++;
				}

				if (!visited_rg[i][j]) {
					queue_rg.add(new int[] { i, j });
					cnt_rg++;
				}
				// 일반인 세기
				while (!queue.isEmpty()) {
					int[] p = queue.poll();

					for (int k = 0; k < 4; k++) {
						int nr = p[0] + dr[k];
						int nc = p[1] + dc[k];

						if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]
								&& grid[p[0]][p[1]].equals(grid[nr][nc])) {
							visited[nr][nc] = true;
							queue.add(new int[] { nr, nc });
						}
					}
				}

				// 적록색약인 세기
				while (!queue_rg.isEmpty()) {
					int[] p = queue_rg.poll();

					for (int k = 0; k < 4; k++) {
						int nr = p[0] + dr[k];
						int nc = p[1] + dc[k];

						if (grid[p[0]][p[1]].equals("B")) {
							if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited_rg[nr][nc]
									&& grid[p[0]][p[1]].equals(grid[nr][nc])) {
								visited_rg[nr][nc] = true;
								queue_rg.add(new int[] { nr, nc });
							}
						} else {
							if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited_rg[nr][nc]
									&& (grid[nr][nc].equals("G") || grid[nr][nc].equals("R"))) {
								visited_rg[nr][nc] = true;
								queue_rg.add(new int[] { nr, nc });
							}
						}
					}
				}
			}
		}
		System.out.println(cnt + " " + cnt_rg);
	}
}
