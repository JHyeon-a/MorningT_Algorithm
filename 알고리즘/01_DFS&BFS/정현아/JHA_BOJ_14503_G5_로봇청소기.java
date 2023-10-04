package BOJ_14503_G5_로봇청소기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int r, c, direct;

		public Node(int r, int c, int direct) {
			super();
			this.r = r;
			this.c = c;
			this.direct = direct;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N: 행 크기
		int M = sc.nextInt(); // M: 열 크기

		int startR = sc.nextInt(); // startR: 시작 r 위치
		int startC = sc.nextInt(); // startC: 시작 c 위치

		int direction = sc.nextInt(); // direction: 방향 (0: 북, 1: 동, 2: 남, 3: 서)

		int[][] space = new int[N][M]; // space: 공간

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				space[i][j] = sc.nextInt(); // 0: 청소 x 공간, 1: 벽
			}
		}

		// 상 하 좌 우 4방향 델타
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<Node> queue = new LinkedList<>(); // queue: bfs를 위해 사용하는 큐

		queue.add(new Node(startR, startC, direction)); // 처음에 시작점을 queue에 넣고 시작

		int cnt = 0; // cnt: 청소하는 칸의 개수

		bfs: while (true) {
			Node e = queue.poll(); // queue에서 하나 꺼내오기

			// 1. 현재 칸 청소가 안 되어 있다면(0)이라면 2로 바꾸고 청소 칸 개수 +1 하기
			if (space[e.r][e.c] == 0) {
				space[e.r][e.c] = 2;
				cnt++;
			}

			// empty: 비어 있는 곳이 있는가?
			boolean empty = false;

			// 주변 4칸 탐색
			for (int d = 0; d < 4; d++) {
				int nr = e.r + dr[d];
				int nc = e.c + dc[d];

				// 범위 밖이면 넘어가고
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				// 벽이거나 청소한 곳이어도 넘어가고
				if (space[nr][nc] == 1 || space[nr][nc] == 2)
					continue;

				// 청소 안 된 곳이 있다면 empty true로 바꾸고 멈추기
				if (space[nr][nc] == 0) {
					empty = true;
					break;
				}

			}

			int nr = e.r;
			int nc = e.c;
			int nd = e.direct;

			// 2. 주변 4칸 중 청소 안 된 빈칸이 없다면
			if (empty == false) {
				// 바라 보는 방향으로 후진하고
				switch (nd) {
				case 0:
					nr = nr + 1;
					break;
				case 1:
					nc = nc - 1;
					break;
				case 2:
					nr = nr - 1;
					break;
				case 3:
					nc = nc + 1;
					break;
				}

				// 범위 벗어나거나 벽이면 멈추고
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || space[nr][nc] == 1)
					break bfs;

				// 아니라면 후진 한 뒤 1로
				queue.add(new Node(nr, nc, nd));

			} else {
				// 3. 주변 4칸 중 청소 안 된 빈칸이 있다면
				while (true) {
					// 반시계 90도 회전
					nd = (4 + nd - 1) % 4;

					// 바라보는 방향 기준으로 앞쪽 칸
					switch (nd) {
					case 0:
						nr = nr - 1;
						break;
					case 1:
						nc = nc + 1;
						break;
					case 2:
						nr = nr + 1;
						break;
					case 3:
						nc = nc - 1;
						break;
					}

					// 만약 반시계 방향으로 돌다가 청소 안 한 곳 발견하면 queue에 넣고 while문 나가기
					if (nr >= 0 && nc >= 0 && nr < N && nc < M && space[nr][nc] == 0) {
						queue.add(new Node(nr, nc, nd));
						break;
					} else {
						// 아니라면 원상복구 해 놓고 가!
						switch (nd) {
						case 0:
							nr = nr + 1;
							break;
						case 1:
							nc = nc - 1;
							break;
						case 2:
							nr = nr - 1;
							break;
						case 3:
							nc = nc + 1;
							break;
						}//switch - 원상복구
					}//if-else (청소 안 된 곳 발견했니?)

				}//반시계 돌면서 확인

			}//if-else 4칸 중 청소 안 된 빈칸이 없거나 있다면

		} // while문 bfs

		System.out.println(cnt);

	}// main

}
