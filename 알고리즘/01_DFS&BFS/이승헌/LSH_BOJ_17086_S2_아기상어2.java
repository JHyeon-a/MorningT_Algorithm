package BOJ_17086_S2_아기상어2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 세로
		int M = sc.nextInt(); // 가로

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 8방향 설정
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

		// 1을 찾기 위한 큐
		Queue<int[]> queue = new LinkedList<>();

		int max_safe = 0; // 안전거리 최대값
		int cnt = 0; // 현재 위치의 안전거리
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 상어 있으면 0이니까 확인안해도돼
				if (map[i][j] == 1)
					continue;

				// 상어가 있는지 확인해보는 방문 배열
				boolean[][] visited = new boolean[N][M];
				queue.add(new int[] { i, j });
				cnt = 1;
				visited[i][j] = true;

				loop1: while (!queue.isEmpty()) {
					// 해당 거리의 탐색이 모두 끝나면 거리 +1 -> 거리 구분 위해 변수 생성
					int q_size = queue.size();
					for (int n = 0; n < q_size; n++) {
						int[] p = queue.poll();

						// 8방 탐색
						for (int k = 0; k < 8; k++) {
							int nr = p[0] + dr[k];
							int nc = p[1] + dc[k];
							// map안에 있으면서 방문 안했다.
							if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
								if (map[nr][nc] == 0) { // 0이면 방문체크하고 큐에 넣어
									queue.add(new int[] { nr, nc });
									visited[nr][nc] = true;
								} else // 1이면 상어 찾았다 끝내
									break loop1;
							}
						}
					}
					cnt++; // 해당 거리의 것들은 다 탐색했다. 다음으로 넘어가자
				}
				queue.clear(); // 큐 비우기
				max_safe = Math.max(max_safe, cnt); // 안전거리 더 큰값을 넣어
			}
		}
		System.out.println(max_safe);
	}
}
