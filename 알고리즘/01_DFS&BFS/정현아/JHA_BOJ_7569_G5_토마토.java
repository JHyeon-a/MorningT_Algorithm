package BOJ_7569_G5_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// Node 클래스 생성
	static class Node {
		int h, r, c, day; // h: 높이, r: 행, c: 열, day: 지난 날짜

		public Node(int h, int r, int c, int day) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
			this.day = day;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // M: 열
		int N = sc.nextInt(); // N: 행
		int H = sc.nextInt(); // H: 개수?높이?

		int[][][] warehouse = new int[H][N][M]; // warehouse: 토마토 보관 창고

		Queue<Node> queue = new LinkedList<>(); // queue: bfs를 위한, 익은 토마토 넣을 거

		int zeroCnt = 0;

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					warehouse[k][i][j] = sc.nextInt();
					// 만약 익은 토마토(1)가 있다면 queue에 집어 넣기
					if (warehouse[k][i][j] == 1) {
						queue.add(new Node(k, i, j, 0));
					} else if (warehouse[k][i][j] == 0) {
						zeroCnt++;
					}

				}
			}
		} // 입력 끝

		int result = 0; // result: 결과로 나타낼 값
		int minDay = 0; // minDay: 최소 날짜

		// 상 하 좌 우 앞 뒤
		int[] dh = { 0, 0, 0, 0, -1, 1 };
		int[] dr = { -1, 1, 0, 0, 0, 0 };
		int[] dc = { 0, 0, -1, 1, 0, 0 };

		// 만약 안 익은 토마토가 0개라면 result = 0
		if (zeroCnt == 0) {
			result = 0;
			// 만약 queue가 비어 있다면(익은 토마토가 하나도 없다면) result = -1
		} else if (queue.isEmpty()) {
			result = -1;
			// 둘 다 해당이 되지 않는다면 bfs 시작
		} else {
			while (!queue.isEmpty()) {
				Node e = queue.poll();
				minDay = Math.max(minDay, e.day);	//minDay 갱신

				for (int d = 0; d < 6; d++) {
					int nh = e.h + dh[d];
					int nr = e.r + dr[d];
					int nc = e.c + dc[d];

					// 범위 안에 있고, 0이라면 (안 익은 토마토라면)
					if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M && warehouse[nh][nr][nc] == 0) {
						warehouse[nh][nr][nc] = 1; // 익은 토마토로 바꿔주고
						queue.add(new Node(nh, nr, nc, e.day + 1));
					}

				} // 6방향 델타

			} // while문 bfs 끝

			//result를 진행 날짜로 넣어주기
			result = minDay;

			// 3중 for문 돌면서 0 있는 check
			loop: for (int k = 0; k < H; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						// 만약 0이 있으면 못 익는 게 있는 거니까 result를 -1로 바꿔주기
						if (warehouse[k][i][j] == 0) {
							result = -1;
							break loop;
						}

					}
				}
			}

		} // if elseif else

		System.out.println(result);

	}//main

}
