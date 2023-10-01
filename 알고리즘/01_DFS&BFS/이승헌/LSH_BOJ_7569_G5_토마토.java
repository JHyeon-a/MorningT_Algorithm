package BOJ_7569_G5_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(); // 가로
		int N = sc.nextInt(); // 세로
		int H = sc.nextInt(); // 높이

		int[][][] box = new int[N][M][H];

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					box[i][j][h] = sc.nextInt();
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[i][j][h] == 1)
						queue.add(new int[] { i, j, h });
				}
			}
		}

		int[] dr = { -1, 1, 0, 0, 0, 0 };
		int[] dc = { 0, 0, -1, 1, 0, 0 };
		int[] dh = { 0, 0, 0, 0, -1, 1 };

		int time = -1;

		while (!queue.isEmpty()) {
			int q_size = queue.size();

			for (int i = 0; i < q_size; i++) {
				int[] p = queue.poll();

				for (int k = 0; k < 6; k++) {
					int nr = p[0] + dr[k];
					int nc = p[1] + dc[k];
					int nh = p[2] + dh[k];

					if (nr >= 0 && nc >= 0 && nh >= 0 && nr < N && nc < M && nh < H && box[nr][nc][nh] == 0) {
						box[nr][nc][nh] = 1;
						queue.add(new int[] { nr, nc, nh });

					}
				}
			}
			time++;
		}
		loop1: for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[i][j][h] == 0) {
						time = -1;
						break loop1;
					}
				}
			}
		}
		System.out.println(time);
	}
}
