package BOJ_7576_G5_토마토;

//BOJ_7569_토마토 풀이 참고

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int r, c, day;

		public Node(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // M: 열
		int N = sc.nextInt(); // N: 행

		int[][] warehouse = new int[N][M]; // warehouse: 창고
		int zeroNum = 0; // zeroNum: 0의 개수
		Queue<Node> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				warehouse[i][j] = sc.nextInt();
				if (warehouse[i][j] == 0) {
					zeroNum++;
				} else if (warehouse[i][j] == 1) {
					queue.add(new Node(i, j, 0));
				}
			}
		} // 창고 다 입력하고

		int result = 0;
		int minDay = 0;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		if (zeroNum == 0) {
			result = 0;
		} else if (queue.isEmpty()) {
			result = -1;
		} else {
			while (!queue.isEmpty()) {
				Node e = queue.poll();
				minDay = Math.max(minDay, e.day);

				for (int d = 0; d < 4; d++) {
					int nr = e.r + dr[d];
					int nc = e.c + dc[d];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M && warehouse[nr][nc] == 0) {
						warehouse[nr][nc] = 1;
						queue.add(new Node(nr, nc, e.day + 1));
					}
				}

			}

			result = minDay;

			loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (warehouse[i][j] == 0) {
						result = -1;
						break loop;
					}
				}
			}

		}

		System.out.println(result);

	}// main

}
