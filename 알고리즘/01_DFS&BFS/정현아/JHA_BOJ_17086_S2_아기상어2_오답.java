package BOJ_17086_S2_아기상어2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * bfs 문제
 * 1. 처음부터 끝까지 for문 두 개로 돌려서
 * 2. queue에 넣고 bfs 하면서 1을 만나면 멈춘 뒤 queue를 다 비우고 max값과 비교해서 갱신했다.
 * 3. 그런데 시간 초과 발생
 * 4. buffered로 바꿔도 똑같이 시간 초과 발생...
 *
 */

public class Main2 {
	static class Node {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N: 공간의 크기(행의 개수)
		int M = sc.nextInt(); // M: 공간의 크기(열의 개수)

		// 상 하 좌 우 상좌 상우 하좌 하우
		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

		int[][] adjArr = new int[N][M]; // adjArr: 인접행렬로 나타내기 위한 배열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				adjArr[i][j] = sc.nextInt(); // adjArr[i][j]에 입력 받기
			}
		}

		boolean[][] visited = new boolean[N][M];

		int max = 0;

		Queue<Node> queue = new LinkedList<>(); // bfs를 위한 queue 생성

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				queue.add(new Node(i, j, 0));
				int cnt = 0;

				while (!queue.isEmpty()) {
					Node e = queue.poll();
					if (adjArr[e.r][e.c] == 1) {
						cnt = e.cnt;
						break;
					}

					visited[e.r][e.c] = true;

					for (int d = 0; d < 8; d++) {
						int nr = e.r + dr[d];
						int nc = e.c + dc[d];

						int ncnt = e.cnt + 1;

						if (nr < N && nc < M && nr >= 0 && nc >= 0) {
							queue.add(new Node(nr, nc, ncnt));
						}

					}

				}

				queue.clear();

				max = Math.max(max, cnt);

			}
		}

		System.out.println(max);

	}// main

}
