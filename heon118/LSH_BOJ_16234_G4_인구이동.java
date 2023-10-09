package BOJ_16234_G4_인구이동;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N개의 나라
		int L = sc.nextInt(); // 인구수 차이의 최소
		int R = sc.nextInt(); // 인구수 차이의 최대

		int[][] land = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				land[i][j] = sc.nextInt();
			}
		}
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int day = 0; // 이 인구이동은 며칠째인가!

		while (true) { // 언제까지 하는지 모르니까 일단 무한반복으로
			Queue<int[]> queue = new LinkedList<>(); // 연합이 어디까지인지알아보는 큐
			boolean[][] visited = new boolean[N][N]; // 방문체크
			int cnt_y = 0; // 연합수
			/*
			 * 하나하나 방문체크할건데 연합에 못낀 애들도 체크해준다. 큐를 사용해 bfs를 돌리는데 나중에 연합 애들 좌표를 몰라서 값을 못 넣어주니까
			 * 큐를 그냥 하나 더 만들었다. - queue_y 더이상 진행되지 않는다는 것을 체크하는 것이 생각하기 어려웠다. - 연합이 만들어지지
			 * 않는다는 것이기에 연합수(cnt_y)를 세주었음 인구 이동이 없는 나라도 연합 하나로 취급해서 cnt_y를 셌다.
			 */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = 0; // 연합에 속한 나라의 총 인구수
					int cnt = 0; // 연합에 속한 나라의 개수
					Queue<int[]> queue_y = new LinkedList<>(); // 연합 큐(나중에 값 넣으려고)
					if (!visited[i][j]) { // 방문하지 않았다면(= 현재 연합에 속하지 않았다면) - 연합의 시작점이라고 할 수 있다.
						queue.add(new int[] { i, j });
						queue_y.add(new int[] { i, j });
						visited[i][j] = true;
						sum += land[i][j];
						cnt++;
						cnt_y++; // 연합의 개수
					}

					// bfs를 돌리는 코드
					while (!queue.isEmpty()) {
						int[] p = queue.poll();

						for (int k = 0; k < 4; k++) {
							int nr = p[0] + dr[k];
							int nc = p[1] + dc[k];

							if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]
									&& Math.abs(land[p[0]][p[1]] - land[nr][nc]) >= L
									&& Math.abs(land[p[0]][p[1]] - land[nr][nc]) <= R) {
								queue.add(new int[] { nr, nc });
								queue_y.add(new int[] { nr, nc });
								visited[nr][nc] = true;
								sum += land[nr][nc];
								cnt++;
							}
						}
					}
					// 큐에 들어왔던(연합에 속했던) 나라들의 인구수를 조정한다.
					while (!queue_y.isEmpty()) {
						int[] p = queue_y.poll();
						land[p[0]][p[1]] = sum / cnt;
					}
				}
			}
			// 모든 좌표를 돌았다 - visited==false 인 곳이 없다는 것
			// 단일 국가여도 연합으로 취급했기 때문에 모든 국가가 단일국가라면 이제 인구이동은 없는거다.
			if (cnt_y == N * N)
				break;
			else
				day++;
		}
		System.out.println(day);
	}
}
