package BOJ_2468_S1_안전영역;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map; // 지도
	static int N;
	static int max_high; // 가장 높은 높이
	static int area; // 영역의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		max_high = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int A = sc.nextInt();
				max_high = max_high < A ? A : max_high; // 가장 높은 높이 구하기
				map[i][j] = A;
			}
		}
		area = 0;
		for (int i = 0; i < max_high; i++) {
			bfs(i);
		}
		System.out.println(area);
	}

	// bfs - h는 잠기는 높이
	private static void bfs(int h) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N]; // 방문 체크
		int cnt = 0; // 현재 높이까지 물에 잠길때 영역의 개수

		// 상하좌우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 잠기지 않고 방문하지 않았어야지
				if (map[i][j] > h && !visited[i][j]) {
					queue.add(new int[] { i, j });
					// 여기서 이어지는 잠기지 않는 영역은 모두 연결되는거니까 영역의 개수나 마찬가지
					cnt++;
				}

				while (!queue.isEmpty()) {
					int[] p = queue.poll();

					for (int k = 0; k < 4; k++) {
						int nr = p[0] + dr[k];
						int nc = p[1] + dc[k];

						if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[nr][nc] > h) {
							visited[nr][nc] = true;
							queue.add(new int[] { nr, nc });
						}
					}
				}
			}
		}
		area = area < cnt ? cnt : area;
	}
}
