package BOJ_7576_G5_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		int[][] box = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
			}
		}

		// 익은 토마토의 위치를 넣는 큐
		Queue<int[]> queue = new LinkedList<>();

		// 한번에 여러 곳에서 익은 토마토 전파 가능하므로 큐에 한번에 다 넣어
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1)
					queue.add(new int[] { i, j });
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		// 시간인데 처음 익어있는 토마토가 큐에 들어가 있기에 자동으로 +1이 됨
		int time = -1;
		while (!queue.isEmpty()) {
			int q_size = queue.size();

			for (int i = 0; i < q_size; i++) {
				int[] p = queue.poll();

				for (int k = 0; k < 4; k++) {
					int nr = p[0] + dr[k];
					int nc = p[1] + dc[k];

					if (nr >= 0 && nc >= 0 && nr < N && nc < M && box[nr][nc] == 0) {
						box[nr][nc] = 1;
						queue.add(new int[] { nr, nc });
					}
				}
			}
			time++;
		}
		// 토마토를 익히는데 띄어져있거나해서 익지 않은 토마토가 있으면 -1
		loop1: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					time = -1;
					break loop1;
				}
			}
		}
		System.out.println(time);
	}
}
