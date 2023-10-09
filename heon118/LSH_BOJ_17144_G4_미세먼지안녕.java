package BOJ_17144_G4_미세먼지안녕;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R;
	static int C;
	static int[] air_r;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt(); // row
		C = sc.nextInt(); // column
		int T = sc.nextInt(); // T초 후 결과

		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		air_r = new int[2]; // 공기청정기의 row 좌표 - column은 어차피 0
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<int[]> queue = new LinkedList<>();
		for (int t = 0; t < T; t++) {
			int[][] munji_map = new int[R][C]; // 먼지를 추가 감소시키는 양만 기록하는 배열 - 먼지의 증감만 체크

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					// 먼지가 있는 곳을 모두 큐에 넣을거야
					if (map[r][c] != 0 && map[r][c] != -1)
						queue.add(new int[] { r, c });
					// 나는 공기청정기 좌표를 알고싶어
					// [1]에만 값이 중복 저장되는데 상관없다. 어차피 [0]은 [1]에서 1을 빼준 값이니까
					if (map[r][c] == -1)
						air_r[1] = r;
				}
			}
			// 공기청정기는 위아래 연속 두칸이니까
			air_r[0] = air_r[1] - 1;

			// bfs 돌려
			while (!queue.isEmpty()) {
				int[] p = queue.poll();
				int cnt = 0; // 이 먼지가 있는 칸에서 다른 칸으로 먼지가 몇번 퍼졌냐 - 퍼진 수 만큼 빼줘야되니까 센다
				for (int k = 0; k < 4; k++) {
					int nr = p[0] + dr[k];
					int nc = p[1] + dc[k];

					// 5 이상이어야 나눠줄게 있다. 5보다 작으면 0을 나눠주는거라 의미가 없어
					if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] != -1 && map[p[0]][p[1]] >= 5) {
						// 해당 칸에 먼지가 이만큼 증가할거야
						munji_map[nr][nc] += map[p[0]][p[1]] / 5;
						cnt++;
					}
				}
				// 먼지를 나눠줬으니까 이만큼 줄어들거야
				munji_map[p[0]][p[1]] -= cnt * (map[p[0]][p[1]] / 5);
			}

			// 먼지의 증감을 나타내는거니까 마지막에 전체 맵에다가 더해줘야지
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					map[r][c] += munji_map[r][c];
				}
			}
			// 돌고 도는 먼지세계
			screw();
		}
		int munji = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				munji += map[r][c];
			}
		}
		System.out.println(munji + 2);
	}

	private static void screw() {
		for (int i = air_r[0] - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			map[0][j] = map[0][j + 1];
		}
		for (int i = 0; i < air_r[0]; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int j = C - 1; j > 1; j--) {
			map[air_r[0]][j] = map[air_r[0]][j - 1];
		}
		map[air_r[0]][1] = 0;

		for (int i = air_r[1] + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			map[R - 1][j] = map[R - 1][j + 1];
		}
		for (int i = R - 1; i >= air_r[1] + 1; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		for (int j = C - 1; j > 1; j--) {
			map[air_r[1]][j] = map[air_r[1]][j - 1];
		}
		map[air_r[1]][1] = 0;
	}

}
